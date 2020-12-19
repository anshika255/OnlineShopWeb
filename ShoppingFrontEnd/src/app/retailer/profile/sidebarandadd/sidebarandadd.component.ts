import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/admin.service';
import { Category } from 'src/app/category.model';
import { Product } from 'src/app/product.model';

@Component({
  selector: 'app-sidebarandadd',
  templateUrl: './sidebarandadd.component.html',
  styleUrls: ['./sidebarandadd.component.css']
})
export class SidebarandaddComponent implements OnInit {
rname : string;
mobile : string;
email : string;
rtlrid:number;
prdct = new Product;
list1:Category[]=[];

constructor(private router : Router, private service : AdminService) { }

  ngOnInit() {
    this.rtlrid = parseInt(sessionStorage.getItem('rid'));
    this.rname = sessionStorage.getItem("rname");
    this.mobile = sessionStorage.getItem("mobile");
    this.email = sessionStorage.getItem("email");
    this.service.getListCategory().subscribe(data => this.list1 = data);
  }

  addProduct()
  {
    this.prdct.imageid=this.prdct.imageid.replace(/^C:\\fakepath\\/i, 'assets/img/product/');
    this.service.addProduct(this.prdct,this.rtlrid,this.prdct.categoryid);
    this.router.navigate(['/activeproducttable']);
    alert("New Product Added Product");
  } 

  onFileChange(event){
    //alert(this.prdct.imageid.replace(/^C:\\fakepath\\/i, ''));
  }

}
