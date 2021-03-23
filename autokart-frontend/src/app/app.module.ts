import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { AccessoryListComponent } from './components/accessory-list/accessory-list.component';
import { AccessoryComponent } from './components/accessory/accessory.component';
import { AddtocartComponent } from './components/addtocart/addtocart.component';
import { AddtowishlistComponent } from './components/addtowishlist/addtowishlist.component';
import { AccessorydetailsComponent } from './components/accessorydetails/accessorydetails.component';
import { AccessoryFilterComponent } from './components/accessory-filter/accessory-filter.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { AuthComponent } from './components/auth/auth.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { PricefilterComponent } from './components/pricefilter/pricefilter.component';
import { SearchComponent } from './components/search/search.component';
import { CartitemsComponent } from './components/cartitems/cartitems.component';
import { SimilaraccessoriesComponent } from './components/similaraccessories/similaraccessories.component';
import { UserprofileComponent } from './components/userprofile/userprofile.component';
import { UserdetailsComponent } from './components/userdetails/userdetails.component';
import { UseraddressComponent } from './components/useraddress/useraddress.component';
import { UserordersComponent } from './components/userorders/userorders.component';
import { UserwishlistComponent } from './components/userwishlist/userwishlist.component';
import { UserorderitemsComponent } from './components/userorderitems/userorderitems.component';
import { AdminComponent } from './components/admin/admin.component';
import { NgMaterialModule } from './ng-material/ng-material.module';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    AccessoryListComponent,
    AccessoryComponent,
    AddtocartComponent,
    AddtowishlistComponent,
    AccessorydetailsComponent,
    AccessoryFilterComponent,
    CheckoutComponent,
    AuthComponent,
    PageNotFoundComponent,
    PricefilterComponent,
    SearchComponent,
    CartitemsComponent,
    SimilaraccessoriesComponent,
    UserprofileComponent,
    UserdetailsComponent,
    UseraddressComponent,
    UserordersComponent,
    UserwishlistComponent,
    UserorderitemsComponent,
    AdminComponent
  ],
  imports: [
    NgMaterialModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
