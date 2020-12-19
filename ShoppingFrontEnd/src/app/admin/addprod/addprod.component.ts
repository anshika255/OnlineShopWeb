import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/admin.service';
import { Product } from 'src/app/product.model';

@Component({
  selector: 'app-addprod',
  templateUrl: './addprod.component.html',
  styleUrls: ['./addprod.component.css']
})
export class AddprodComponent implements OnInit {

  list: Product[] = [];
  
  constructor(private router : Router, private service : AdminService) { }

  ngOnInit() {
    this.service.getListProduct().subscribe(data => this.list = data);
  }

}
