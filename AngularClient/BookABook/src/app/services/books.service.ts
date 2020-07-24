import { Injectable } from '@angular/core';

import { Observable, throwError } from 'rxjs';
import { Book } from 'src/app/models/book.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable()
export class BookService {

  private urlEndpoint = 'https://edge-bookabook.herokuapp.com/books';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.urlEndpoint, this.httpOptions);
  }

  getBookById(id: number): Observable<Book> {
    return this.http.get<Book>(this.urlEndpoint.concat(`/${id}`), this.httpOptions);
  }

  create(book: Book): Observable<Book> {
    return this.http.post<Book>(this.urlEndpoint, book, this.httpOptions);
  }

  delete(id: number): Observable<Book> {
    return this.http.delete<Book>(this.urlEndpoint.concat(`/${id}`), this.httpOptions);
  }

}

