import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product.model';
import { UserLoginService } from '../user-login.service';

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent implements OnInit {
  usrid:number;
  list: Product[] = [];
  constructor(private router : Router, private service : UserLoginService) { }


  ngOnInit() {
    this.usrid = parseInt(sessionStorage.getItem('uid'));
    this.service.fetchCart(this.usrid).subscribe(data => this.list = data);
  }

}
