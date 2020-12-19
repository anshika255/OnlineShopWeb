import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/login.model';
import { UserLoginService } from 'src/app/user-login.service';
import { User } from 'src/app/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login : Login;
  user: User;
  uname:String;

  constructor(private service : UserLoginService, private router : Router){
    this.login = new Login();
  }
  ngOnInit(): void {
    sessionStorage.setItem("user", null);
  }

  async loggedIn(){
    await this.service.login(this.login).then(
          data => this.user = data
    );
    sessionStorage.setItem("user", JSON.stringify(this.user));
    sessionStorage.setItem('uid', String(this.user.userid));
    sessionStorage.setItem("uname", this.user.username);
    sessionStorage.setItem("umobile", this.user.mobile);
    sessionStorage.setItem("uemail", this.user.email);
    this.uname=sessionStorage.getItem("uname");
    //this.router.navigate(['/']);
    window.location.href = 'http://localhost:4200';
  }
}
