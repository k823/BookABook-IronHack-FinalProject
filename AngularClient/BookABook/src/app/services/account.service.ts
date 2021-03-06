import { Injectable } from '@angular/core';

import { Observable, throwError } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';
import { Account } from '../models/account.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { formatDate, registerLocaleData } from '@angular/common';


@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private urlEndpoint = 'https://edge-bookabook.herokuapp.com/accounts';

  httpHeaders = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  getAccounts(): Observable<Account[]> {
    return this.http.get<Account[]>(this.urlEndpoint);
  }
}
