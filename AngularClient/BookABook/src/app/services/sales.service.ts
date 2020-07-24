import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Sales } from '../models/sales.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SalesService {

  private urlEndpoint = 'https://sales-bookabook.herokuapp.com/';

  httpHeaders = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  constructor(
    private http: HttpClient
    ) { }

    getSales(): Observable<Sales[]> {
      return this.http.get<Sales[]>(this.urlEndpoint);
    }
}
