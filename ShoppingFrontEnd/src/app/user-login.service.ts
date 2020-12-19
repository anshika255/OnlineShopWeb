import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Login } from './login.model';
import { Order } from './order.model';
import { Product } from './product.model';
import { User } from './user.model';

@Injectable({
  providedIn: 'root'
})
export class UserLoginService {
  private baseUrl: string = "http://localhost:8875";

  constructor(private router:Router, private http : HttpClient) { }

  save(usr : User) {
    this.http.post(this.baseUrl + "/addUser", usr).subscribe(data => data = usr);
    data => data = usr;
  }

  login(login : Login) : Promise<User> {
    const params = new HttpParams().append('username', login.username)
          .append('password', login.password);
    let result = this.http.get<User>(this.baseUrl + "/login", {params : params}).toPromise();
    return result;
  }
  fetchOrders(id: number): Observable<Order[]>
  {
   return this.http.get<Order[]>(this.baseUrl+"/viewOrders/"+id);
  } 
  fetchCart(id: number): Observable<Product[]>
  {
   return this.http.get<Product[]>(this.baseUrl+"/viewCart/"+id);
  } 
  fetchWishlist(id: number): Observable<Product[]>
  {
   return this.http.get<Product[]>(this.baseUrl+"/viewWishlist/"+id);
  } 
}
