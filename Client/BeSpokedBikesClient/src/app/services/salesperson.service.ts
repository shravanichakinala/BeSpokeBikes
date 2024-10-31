// salesperson.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SalespersonService {
  //private apiUrl = 'http://localhost:8080/profisee/api/sales/salespersons';
  private apiUrl =  'http://localhost:8080/profisee/api/sales/salespersons';

  constructor(private http: HttpClient) { }

  getAllSalespersons(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}`);
  }

  getSalespersonById(id: number): Observable<any> {
    console.log('hello inside ');
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }



  updateSalesperson(id: number, salesperson: any): Observable<any> {
    console.log();
    return this.http.put<any>(`${this.apiUrl}/${id}`, salesperson);
  }
  deleteSalesperson(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
