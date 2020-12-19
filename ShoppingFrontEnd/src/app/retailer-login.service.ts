import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginRetailer } from 'src/retailer-login.model';
import { Product } from './product.model';
import { Retailer } from './retailer.model';

@Injectable({
  providedIn: 'root'
})
export class RetailerLoginService {
  private baseUrl: string = "http://localhost:8875";

  constructor(private router:Router, private http : HttpClient) { }

  save(rtlr : Retailer) {
    this.http.post(this.baseUrl + "/addretailer", rtlr).subscribe(data => data = rtlr);
    data => data = rtlr;
  }

  login(login : LoginRetailer) : Promise<Retailer> {
    const params = new HttpParams().append('email', login.email)
          .append('password', login.password);
    let result = this.http.get<Retailer>(this.baseUrl + "/loginRetailer", {params : params}).toPromise();
    return result;
  }

  search(id : number) : Observable<Retailer> {
    return this.http.get<Retailer>(this.baseUrl + "/fetch/" + id);
  }
  
  fetchProduct(id: number): Observable<Product[]>
  {
   return this.http.get<Product[]>(this.baseUrl+"/viewProducts/"+id);
  } 

  findByIndex(id: number): Observable<Product>
  {
   return this.http.get<Product>(this.baseUrl+"/fetchProduct/"+id);
  } 
  update(prdct: Product)
   {
    this.http.put(this.baseUrl + "/updateProduct",prdct).subscribe(data => data = prdct);
   }
   edit(index: number)
   {
     this.router.navigate(['/editproduct'],{queryParams: {index: index}});
   }
   deleteProduct(id:number) {
    this.http.delete(this.baseUrl+"/delProduct/"+id).subscribe();
    } 

 

 
}
