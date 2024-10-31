
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SalespersonService } from 'src/app/services/salesperson.service';

@Component({
  selector: 'app-salesperson-update',
  templateUrl: './salesperson-update.component.html',
  styleUrls: ['./salesperson-update.component.css']
})
export class SalespersonUpdateComponent implements OnInit {

  salesperson: any = {};

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private salespersonService: SalespersonService
  ) {}

  ngOnInit(): void {
    const id = +(this.route.snapshot.paramMap.get('id') || 0);  // Fetch ID from route
    this.salespersonService.getSalespersonById(id).subscribe(
      data => {
        this.salesperson = data;  // Assign fetched data to salesperson
      },
      error => {
        console.error('Error fetching salesperson data', error);
      }
    );
  }

  // updateSalesperson(): void {
  //   this.salespersonService.updateSalesperson(this.salesperson.id, this.salesperson).subscribe(() => {
  //     this.router.navigate(['/salespersons']);  // Redirect back to the salespersons list
  //   });
  // }

  updateSalesperson(): void {
    if (this.salesperson && this.salesperson.id) {  // Ensure salesperson data is loaded
      this.salespersonService.updateSalesperson(this.salesperson.id, this.salesperson).subscribe(() => {
        this.router.navigate(['/salespersons']);  // Redirect back to the salespersons list
      });
    } else {
      console.error('Salesperson data is not loaded');  // Log error if salesperson data is not ready
    }
  }


  cancel(): void {
    this.router.navigate(['/salespersons']);  // Go back to the salespersons list without saving
  }
}
