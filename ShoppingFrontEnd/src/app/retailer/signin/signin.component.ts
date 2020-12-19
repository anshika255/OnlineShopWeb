import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RetailerLoginService } from 'src/app/retailer-login.service';
import { Retailer } from 'src/app/retailer.model';
import { LoginRetailer } from 'src/retailer-login.model';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  login : LoginRetailer;
  retailer: Retailer;

  constructor(private service : RetailerLoginService, private router : Router){
    this.login = new LoginRetailer();
  }
  ngOnInit(): void {
    sessionStorage.setItem("retailer", null);
  }

  

  async loggedIn(){
    await this.service.login(this.login).then(
          data => this.retailer = data
    );
     //alert(JSON.stringify(this.retailer));
    sessionStorage.setItem("retailer", JSON.stringify(this.retailer));
    sessionStorage.setItem('rid', String(this.retailer.retailerid));
    sessionStorage.setItem("rname", this.retailer.retailername)
    sessionStorage.setItem("mobile", this.retailer.mobile)
    sessionStorage.setItem("email", this.retailer.email)
    //this.router.navigate(['/retailerprofile']);
    window.location.href = 'http://localhost:4200/retailerprofile';
  }

}