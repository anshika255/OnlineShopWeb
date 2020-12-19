import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from 'src/app/order.model';
import { UserLoginService } from 'src/app/user-login.service';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {

  usrid:number;
  list: Order[] = [];
  uname : string;
  umobile : string;
  uemail : string;
  constructor(private router : Router, private service : UserLoginService) { }

  ngOnInit() {
    this.uname = sessionStorage.getItem("uname");
    this.umobile = sessionStorage.getItem("umobile");
    this.uemail = sessionStorage.getItem("uemail");
    this.usrid = parseInt(sessionStorage.getItem('uid'));
    this.service.fetchOrders(this.usrid).subscribe(data => this.list = data);
  }

}
