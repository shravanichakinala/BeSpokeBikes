

import { Component, OnInit } from '@angular/core';
import { SalespersonService } from 'src/app/services/salesperson.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-salespersons-list',
  templateUrl: './salespersons-list.component.html',
  styleUrls: ['./salespersons-list.component.css']
})
export class SalespersonsListComponent implements OnInit {
  salespersons: any[] = [];

  constructor(private salespersonService: SalespersonService, private router: Router) {}

  ngOnInit(): void {
    this.loadSalespersons();
  }

  loadSalespersons(): void {
    this.salespersonService.getAllSalespersons().subscribe(data => {
      this.salespersons = data;
    });
  }

  editSalesperson(id: number): void {
    this.router.navigate([`/salespersons/${id}/edit`]);
  }

  deleteSalesperson(id: number): void {
    if (confirm('Are you sure you want to delete this salesperson?')) {
      this.salespersonService.deleteSalesperson(id).subscribe(() => {
        this.loadSalespersons(); // Reload the list after deletion
      });
    }
  }




}
