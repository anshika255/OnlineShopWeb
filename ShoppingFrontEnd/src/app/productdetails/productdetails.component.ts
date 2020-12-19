import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';
import { Product } from '../product.model';

@Component({
  selector: 'app-productdetails',
  templateUrl: './productdetails.component.html',
  styleUrls: ['./productdetails.component.css']
})
export class ProductdetailsComponent implements OnInit {

  list: Product[] = [];
  
  constructor(private router : Router, private service : AdminService) { }

  ngOnInit() {
    this.service.getListProduct().subscribe(data => this.list = data);
  }

}
