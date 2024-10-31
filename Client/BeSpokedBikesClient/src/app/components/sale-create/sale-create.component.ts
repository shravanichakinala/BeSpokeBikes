import { Component } from '@angular/core';
import { SalesService } from 'src/app/services/sales.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sale-create',
  templateUrl: './sale-create.component.html',
  styleUrls: ['./sale-create.component.css']
})
export class SaleCreateComponent {
  sale: any = {
    product: { id: null },
    customer: { id: null },
    salesperson: { id: null },
    salesDate: '',
    price: 0,
    commission: 0
  };

  constructor(private salesService: SalesService, public router: Router) {}

  createSale(): void {
    this.salesService.createSale(this.sale).subscribe(() => {
      this.router.navigate(['/sales']); // Redirect to sales list after creation
    });
  }


  cancel(): void {
    this.router.navigate(['/sales']); // Navigate to sales list without saving
  }
}
