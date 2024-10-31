import { Component, OnInit } from '@angular/core';


import { SalesService } from 'src/app/services/sales.service';

@Component({
  selector: 'app-sales-list',
  templateUrl: './sales-list.component.html'
})
export class SalesListComponent implements OnInit {
  sales: any[] = [];
  startDate: string = '';
  endDate: string = '';

  constructor(private salesService: SalesService) {}

  ngOnInit(): void {
    this.getSales();
  }

  getSales(): void {
    if (this.startDate && this.endDate) {
      this.salesService.getSalesByDateRange(this.startDate, this.endDate).subscribe(data => {
        this.sales = data;
      });
    } else {
      this.salesService.getAllSales().subscribe(data => {
        this.sales = data;
      });
    }
  }


}
