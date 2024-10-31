import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SalespersonsListComponent } from './components/salespersons-list/salespersons-list.component';
import { SalespersonUpdateComponent } from './components/salesperson-update/salesperson-update.component';
import { ProductsListComponent } from './components/products-list/products-list.component';
import { ProductUpdateComponent } from './components/product-update/product-update.component';
import { CustomersListComponent } from './components/customers-list/customers-list.component';
import { SalesListComponent } from './components/sales-list/sales-list.component';
import { CommissionReportComponent } from './components/commission-report/commission-report.component';
import { SaleCreateComponent } from './components/sale-create/sale-create.component';
import { MainPageComponent } from './components/main-page/main-page.component';





const routes: Routes = [
  { path: '', component: MainPageComponent }, // Root path loads MainPageComponent
  { path: 'salespersons', component: SalespersonsListComponent },
  { path: 'salespersons/:id/edit', component: SalespersonUpdateComponent },
  { path: 'products', component: ProductsListComponent },
  { path: 'products/:id/edit', component: ProductUpdateComponent },
  { path: 'customers', component: CustomersListComponent },
  { path: 'sales', component: SalesListComponent },
  { path: 'sales/create', component: SaleCreateComponent },
  { path: 'report', component: CommissionReportComponent },

  // Redirect any unmatched paths to the main page or salespersons as default
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
