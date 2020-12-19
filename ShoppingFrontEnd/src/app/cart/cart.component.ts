import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';
import { Product } from '../product.model';
import { UserLoginService } from '../user-login.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls:['./cart.component.css']
})
export class CartComponent implements OnInit {

  usrid:number;
  list: Product[] = [];
  constructor(private router : Router, private service : UserLoginService,private service2:AdminService) { }

  ngOnInit() {
    this.usrid = parseInt(sessionStorage.getItem('uid'));
    if(!this.usrid){
      this.router.navigate(['/login']);
      }
      else{
    this.service.fetchCart(this.usrid).subscribe(data => this.list = data);
      }
  }

  RemoveProductfromCart(productId:number)
    {
      //alert(this.usrid+"/t"+productId);
      this.service2.deleteProductfromCart(productId,this.usrid);
      alert("Product Removed from Cart");
      window.location.href = 'http://localhost:4200/cart';
    } 
  
    checkout(productId:number)
   {
     alert(productId);
    sessionStorage.setItem("prdctid", String(productId));
    this.router.navigate(['/address']);
   } 

  
  
}
