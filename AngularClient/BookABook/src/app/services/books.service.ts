import { Injectable } from '@angular/core';

import { Observable, throwError } from 'rxjs';
import { Book } from 'src/app/models/book.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable()
export class BookService {

  private urlEndpoint = 'http://localhost:8080/books';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + btoa('client:client')
    })
  };

  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.urlEndpoint);
  }

}

