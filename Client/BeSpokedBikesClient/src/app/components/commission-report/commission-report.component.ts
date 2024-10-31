
import { Component, OnInit } from '@angular/core';
import { SalesService } from 'src/app/services/sales.service';

@Component({
  selector: 'app-commission-report',
  templateUrl: './commission-report.component.html',
  styleUrls: ['./commission-report.component.css']
})
export class CommissionReportComponent implements OnInit {
  reportData: any[] = [];
  startDate: string = '';
  endDate: string = '';

  constructor(private salesService: SalesService) {}

  ngOnInit(): void {}

  fetchReport(): void {
    this.salesService.getQuarterlyCommissionReport(this.startDate, this.endDate).subscribe(data => {
      this.reportData = data;
    });
  }
}

