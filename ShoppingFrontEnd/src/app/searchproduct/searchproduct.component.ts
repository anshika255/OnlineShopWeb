import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Wishlist } from 'src/wishlist.model';
import { AdminService } from '../admin.service';
import { Cart } from '../cart.model';
import { Category } from '../category.model';
import { Product } from '../product.model';


@Component({
  selector: 'app-searchproduct',
  templateUrl: './searchproduct.component.html',
  styleUrls: ['./searchproduct.component.css']
})
export class SearchproductComponent implements OnInit {

  list: Product[] = [];
  list1:Category[]=[];
  list2: Product[] = [];
  prdct : Product;
  crt = new Cart;
  wslt=new Wishlist;
  uid:number;
  name :String;
  constructor(private router : Router, private service : AdminService) { }

  ngOnInit() {
    
    this.uid = parseInt(localStorage.getItem('uid'));
    this.service.getListProduct().subscribe(data => this.list = data);
    this.service.getListBrands().subscribe(data => this.list2 = data);
    this.service.getListCategory().subscribe(data => this.list1 = data);
  }

  searchProduct(name:String)
  {
    
    this.service.search(name).subscribe(data => this.list = data);
  }

  searchProductByCategory(categoryname:String)
  {
    alert(categoryname);
    this.service.fetchProductByCategory(categoryname).subscribe(data => this.list = data);
  }

  addProducttoCart(productid:number)
  {
    this.service.addProducttoCart(this.crt,this.uid,productid);
    //this.router.navigate(['/cart']);
    alert("Product Added to cart");
  } 

  addProducttoWishlist(productid:number)
  {
    this.service.addProducttoWishlist(this.wslt,this.uid,productid);
    //this.router.navigate(['/cart']);
    alert("Product Added to Wishlist");
  } 


}
