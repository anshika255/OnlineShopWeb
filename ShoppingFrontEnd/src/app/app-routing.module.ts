import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from'./user/login/login.component';
import { RegisterComponent } from'./user/register/register.component';
import { ForgotComponent } from'./user/forgot/forgot.component';
import {SigninComponent} from './retailer/signin/signin.component';
import {ForgetComponent} from './retailer/forget/forget.component';
import {SignupComponent} from './retailer/signup/signup.component';
import { CartComponent } from './cart/cart.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { CarouselComponent } from './carousel/carousel.component';
import { ProductsComponent } from './products/products.component';
import { ProductdetailsComponent } from './productdetails/productdetails.component';
import {AdminlogComponent} from './admin/adminlog/adminlog.component';
import {AddprodComponent} from './admin/addprod/addprod.component';
import {AddretailerComponent} from './admin/addretailer/addretailer.component';
import {SidebarandaddComponent} from './retailer/profile/sidebarandadd/sidebarandadd.component';
import {DisplayProductsComponent } from './retailer/profile/display-products/display-products.component';
import {SearchproductComponent} from './searchproduct/searchproduct.component';
import {UserdashboardComponent } from './user/userprofile/userdashboard/userdashboard.component';
import {AboutusComponent} from './aboutus/aboutus.component';
import {AddressComponent} from './address/address.component';
import {PaymentComponent} from './payment/payment.component';
import{EditproductComponent} from './retailer/profile/editproduct/editproduct.component';

const routes: Routes = [
  {path: '', component: CarouselComponent},
  {path: 'editproduct',component:EditproductComponent},
  {path: 'payment',component:PaymentComponent},
  {path: 'address',component:AddressComponent},
  { path: 'aboutus',component:AboutusComponent },
  { path: 'searchProducts',component:SearchproductComponent },
  { path: 'activeproducttable',component:DisplayProductsComponent },
  { path: 'retailerprofile',component:SidebarandaddComponent },
   { path: 'login',component:LoginComponent },
   { path: 'register',component:RegisterComponent },
   { path: 'forgot',component:ForgotComponent },
   { path: 'signin',component:SigninComponent},
   { path: 'signup',component:SignupComponent},
   { path: 'forget',component:ForgetComponent },
   { path: 'cart',component:CartComponent},
   {path: 'wishlist',component:WishlistComponent},
   {path: 'carousel',component:CarouselComponent},
   {path: 'products',component:ProductsComponent},
   {path: 'productdetails',component:ProductdetailsComponent},
   { path: 'adminlog',component:AdminlogComponent },
   { path: 'addprod',component:AddprodComponent },
   { path: 'addretailer',component:AddretailerComponent },
   {path: 'userdashboard', component:UserdashboardComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
