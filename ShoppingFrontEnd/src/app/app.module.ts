import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './user/login/login.component';
import { RegisterComponent } from './user/register/register.component';
import { ForgotComponent } from './user/forgot/forgot.component';
import { CartComponent } from './cart/cart.component';
import { FooterComponent } from './footer/footer.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { CarouselComponent } from './carousel/carousel.component';
import { SigninComponent } from './retailer/signin/signin.component';
import { SignupComponent } from './retailer/signup/signup.component';
import { ForgetComponent } from './retailer/forget/forget.component';
import { ProductsComponent } from './products/products.component';
import { ProductdetailsComponent } from './productdetails/productdetails.component';
import { AdminlogComponent } from './admin/adminlog/adminlog.component';
import { AddprodComponent } from './admin/addprod/addprod.component';
import { AddretailerComponent } from './admin/addretailer/addretailer.component';
import { SidebarandaddComponent } from './retailer/profile/sidebarandadd/sidebarandadd.component';
import { DisplayProductsComponent } from './retailer/profile/display-products/display-products.component';
import { SearchproductComponent } from './searchproduct/searchproduct.component';
import { UserdashboardComponent } from './user/userprofile/userdashboard/userdashboard.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { PaymentComponent } from './payment/payment.component';
import { AddressComponent } from './address/address.component';
import { EditproductComponent } from './retailer/profile/editproduct/editproduct.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    RegisterComponent,
    ForgotComponent,
    CartComponent,
    FooterComponent,
    WishlistComponent,
    CarouselComponent,
    SigninComponent,
    SignupComponent,
    ForgetComponent,
    ProductsComponent,
    ProductdetailsComponent,
    AdminlogComponent,
    AddprodComponent,
    AddretailerComponent,
    SidebarandaddComponent,
    DisplayProductsComponent,
    SearchproductComponent,
    UserdashboardComponent,
    AboutusComponent,
    PaymentComponent,
    AddressComponent,
    EditproductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
