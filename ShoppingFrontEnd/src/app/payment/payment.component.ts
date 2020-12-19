import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';
import { Order } from '../order.model';
import { Product } from '../product.model';
import { UserLoginService } from '../user-login.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  uid:number;
  pid:number;
  ordr = new Order;
  constructor(private router : Router, private service : AdminService,private service2:UserLoginService) { }

  ngOnInit() {
    this.uid = parseInt(sessionStorage.getItem('uid'));
    this.pid = parseInt(sessionStorage.getItem('prdctid'));
  }

   PlaceOrder()
  {
    //alert(this.pid)
    this.service.addOrder(this.ordr,this.uid,this.pid);
    this.service.deleteProductfromCart(this.pid,this.uid);
    alert("Product Ordered,Please Check your Email");
    this.router.navigate(['/userdashboard']);
    
  } 
}
