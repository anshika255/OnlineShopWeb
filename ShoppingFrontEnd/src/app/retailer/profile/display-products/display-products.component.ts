import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/product.model';
import { RetailerLoginService } from 'src/app/retailer-login.service';
import { Retailer } from 'src/app/retailer.model';

@Component({
  selector: 'app-display-products',
  templateUrl: './display-products.component.html',
  styleUrls: ['./display-products.component.css']
})
export class DisplayProductsComponent implements OnInit {
  rtlrid:number;
  list: Product[] = [];
  prdct:Product;
  constructor(private router : Router, private service : RetailerLoginService) { }
  
  ngOnInit() {
    this.rtlrid = parseInt(sessionStorage.getItem('rid'));
    this.service.fetchProduct(this.rtlrid).subscribe(data => this.list = data);
    
  }

  EditProduct(productId:number){
    this.service.edit(productId);
  }

  RemoveProduct(productId:number)
    {
      this.service.deleteProduct(productId);
      alert("Product Removed ");
      window.location.href = 'http://localhost:4200/activeproducttable';
    } 

}
