import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/product.model';
import { RetailerLoginService } from 'src/app/retailer-login.service';

@Component({
  selector: 'app-editproduct',
  templateUrl: './editproduct.component.html',
  styleUrls: ['./editproduct.component.css']
})
export class EditproductComponent implements OnInit {
  prdct:Product;
  constructor(private router : Router, private service : RetailerLoginService,private route: ActivatedRoute) { 
    this.prdct = new Product();
  }
  

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
        this.service.findByIndex(params['index']).subscribe(data => this.prdct = data);
      });
      //alert(this.prdct.name);
  }
  updateEmp()
  {
    this.service.update(this.prdct);
    this.router.navigate(['/activeproducttable']);
  }

}
