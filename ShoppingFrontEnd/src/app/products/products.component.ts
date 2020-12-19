import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Wishlist } from 'src/wishlist.model';
import { AdminService } from '../admin.service';
import { Cart } from '../cart.model';
import { Category } from '../category.model';
import { Product } from '../product.model';
import { User } from '../user.model';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  list: Product[] = [];
  list1:Category[]=[];
  list2: Product[] = [];
  prdct : Product;
  crt = new Cart;
  wslt=new Wishlist;
  name: String;
  uid:number;
  uname:String;
  constructor(private router : Router, private service : AdminService) { }

  ngOnInit() {
    this.uname=sessionStorage.getItem("uname");
    this.uid = parseInt(sessionStorage.getItem('uid'));
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
    //alert(categoryname);
    this.service.fetchProductByCategory(categoryname).subscribe(data => this.list = data);
  }

  searchProductByBrand(brand:String)
  {
    //alert(brand);
    this.service.fetchProductByBrand(brand).subscribe(data => this.list = data);
  }

  addProducttoCart(productid:number)
  {
   if(!this.uname){
   this.router.navigate(['/login']);
   }
   else{
    this.service.addProducttoCart(this.crt,this.uid,productid);
    this.router.navigate(['/cart']);
    alert("Product Added to cart");
   }
  } 

  addProducttoWishlist(productid:number)
  {
    if(!this.uname){
      this.router.navigate(['/login']);
      }
      else{
    this.service.addProducttoWishlist(this.wslt,this.uid,productid);
    this.router.navigate(['/wishlist']);
    alert("Product Added to Wishlist");
      }
  } 

  sort()
   {
     this.list.sort((a,b) => a.price > b.price ? 1 : ((a.price < b.price) ? -1 : 0));
  }

  sorthigh()
   {
     this.list.sort((a,b) => a.price < b.price ? 1 : ((a.price > b.price) ? -1 : 0));
  }

}
