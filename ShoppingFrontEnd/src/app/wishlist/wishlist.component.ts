import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';
import { Cart } from '../cart.model';
import { Product } from '../product.model';
import { UserLoginService } from '../user-login.service';

@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})
export class WishlistComponent implements OnInit {

  usrid:number;
  list: Product[] = [];
  crt = new Cart;
  constructor(private router : Router, private service2 : AdminService,private service:UserLoginService) { }

  
    ngOnInit() {
      
      this.usrid = parseInt(sessionStorage.getItem('uid'));
      if(!this.usrid){
        this.router.navigate(['/login']);
        }
        else{
      this.service.fetchWishlist(this.usrid).subscribe(data => this.list = data);
        }
    }

    RemoveProductfromWishlist(productId:number)
    {
      //alert(this.usrid+"/t"+productId);
      this.service2.deleteProductfromWishlist(productId,this.usrid);
      alert("Product Removed from wishlist");
      window.location.href = 'http://localhost:4200/wishlist';
    } 

    MovetoCart(productId:number)
    {
      this.service2.deleteProductfromWishlist(productId,this.usrid);
      this.service2.addProducttoCart(this.crt,this.usrid,productId);
      alert("Product Moved to Cart");
      window.location.href = 'http://localhost:4200/cart';
    }
  

}
