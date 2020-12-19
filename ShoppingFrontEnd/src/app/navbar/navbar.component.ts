import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  uname : string
  rname : string
  constructor(private router : Router) { }

  ngOnInit() {
    this.uname = sessionStorage.getItem("uname");
    this.rname = sessionStorage.getItem("rname");
  }

  logout(){
    sessionStorage.clear();
     sessionStorage.removeItem('uname');
     sessionStorage.removeItem('rname');
    this.uname=null;
    this.rname=null;
      //this.router.navigate(['/'])
  }

}
