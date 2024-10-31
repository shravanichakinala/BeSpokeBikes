// sales.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SalesService {
  private apiUrl = 'http://localhost:8080/profisee/api/sales';
  private apiUrlcreate = 'http://localhost:8080/profisee/api/sales/createSale';


  constructor(private http: HttpClient) { }

  getAllSales(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/all`);
  }

  getSalesByDateRange(startDate: string, endDate: string): Observable<any[]> {
    const params = new HttpParams()
      .set('startDate', startDate)
      .set('endDate', endDate);
    return this.http.get<any[]>(`${this.apiUrl}/by-date`, { params });
  }

  createSale(sale: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrlcreate}`, sale);
  }


  getQuarterlyCommissionReport(startDate: string, endDate: string): Observable<any[]> {
    let params = new HttpParams().set('startDate', startDate).set('endDate', endDate);
    return this.http.get<any[]>(`${this.apiUrl}/commission-report`, { params });
  }

}
