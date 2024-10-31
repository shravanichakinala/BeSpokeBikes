import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalespersonsListComponent } from './salespersons-list.component';

describe('SalespersonsListComponent', () => {
  let component: SalespersonsListComponent;
  let fixture: ComponentFixture<SalespersonsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SalespersonsListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalespersonsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
