// src/app/app.module.ts

import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';


// Import all the components you're using here
import { SalesListComponent } from './components/sales-list/sales-list.component';
import { CommissionReportComponent } from './components/commission-report/commission-report.component';
import { CustomersListComponent } from './components/customers-list/customers-list.component';
import { ProductUpdateComponent } from './components/product-update/product-update.component';


import {SalespersonUpdateComponent  } from './components/salesperson-update/salesperson-update.component';
import {SalespersonsListComponent  } from './components/salespersons-list/salespersons-list.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

import { ProductsListComponent } from './components/products-list/products-list.component';

import { SaleCreateComponent } from './components/sale-create/sale-create.component';






@NgModule({
  declarations: [
    AppComponent,
    CommissionReportComponent ,
    SalesListComponent,
    CustomersListComponent,
    ProductUpdateComponent,
    SalespersonUpdateComponent ,
    SalespersonsListComponent,
    ProductsListComponent ,
    SaleCreateComponent ,



  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatTableModule,
    MatCardModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule
  ],
  providers: [
    provideAnimationsAsync()
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],  // Add this as a last resort


  bootstrap: [AppComponent]
})
export class AppModule { }


