import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Wishlist } from 'src/wishlist.model';
import { Cart } from './cart.model';
import { Category } from './category.model';
import { Order } from './order.model';
import { Product } from './product.model';
import { Retailer } from './retailer.model';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private baseUrl: string = "http://localhost:8875";
  rtlr : Retailer;
  prdct:Product;
  ctgry:Category;
  constructor(private router:Router, private http : HttpClient) { }

  getList()
    {
      return this.http.get<Retailer[]>(this.baseUrl+"/list");
    }
  getListProduct()
    {
      return this.http.get<Product[]>(this.baseUrl+"/listProduct");
    } 
  getListCategory()
    {
      return this.http.get<Category[]>(this.baseUrl+"/listCategory");
    }  
  getListBrands()
    {
      return this.http.get<Product[]>(this.baseUrl+"/fetchProductBrands");
    }
  search(name: String): Observable<Product[]>
    {
     return this.http.get<Product[]>(this.baseUrl+"/fetchProductByName/"+name);
    }  
  fetchProductByCategory(categoryname: String): Observable<Product[]>
    {
     return this.http.get<Product[]>(this.baseUrl+"/fetchProductByCategory/"+categoryname);
    }  
  fetchProductByBrand(brand: String): Observable<Product[]>
    {
     return this.http.get<Product[]>(this.baseUrl+"/fetchProductBybrand/"+brand);
    }    
    
  addProduct(prdct : Product,id:number,id2:number) {
      this.http.post(this.baseUrl + "/addProduct/"+id+"/"+id2, prdct).subscribe(data => data = prdct);
      data => data = prdct;
    }
  addProducttoCart(crt : Cart,id:number,id2:number) {
      this.http.post(this.baseUrl + "/addProducttocart/"+id+"/"+id2, crt).subscribe(data => data = crt);
      data => data = crt;
    }

  addProducttoWishlist(wslt : Wishlist,id:number,id2:number) {
      this.http.post(this.baseUrl + "/addProducttowishlist/"+id+"/"+id2, wslt).subscribe(data => data = wslt);
      data => data = wslt;
    } 
  deleteProductfromWishlist(id:number,id2:number) {
    this.http.delete(this.baseUrl+"/delProductfromWishlist/"+id+"/"+id2).subscribe();
    } 
  deleteProductfromCart(id:number,id2:number) {
      this.http.delete(this.baseUrl+"/delProductfromCart/"+id+"/"+id2).subscribe();
      } 
  addOrder(ordr : Order,id:number,id2:number) {
        this.http.post(this.baseUrl + "/addOrder/"+id+"/"+id2, ordr).subscribe(data => data = ordr);
        data => data = ordr;
      }
  deleteRetailer(id:number) {
        this.http.delete(this.baseUrl+"/delretailer/"+id).subscribe();
        }  
                
    
    
  
    
    
}
