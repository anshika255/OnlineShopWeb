import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/admin.service';
import { Retailer } from 'src/app/retailer.model';

@Component({
  selector: 'app-addretailer',
  templateUrl: './addretailer.component.html',
  styleUrls: ['./addretailer.component.css']
})
export class AddretailerComponent implements OnInit {

  list: Retailer[] = [];
  
  constructor(private router : Router, private service : AdminService) { }

  ngOnInit() {
    this.service.getList().subscribe(data => this.list = data);
  }

  RemoveRetailer(retailerid:number)
    {
      //alert(this.usrid+"/t"+productId);
      this.service.deleteRetailer(retailerid);
      alert("Retailer Removed ");
      window.location.href = 'http://localhost:4200/addretailer';
    } 


}
