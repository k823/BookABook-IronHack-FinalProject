import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

import { Book } from 'src/app/models/book.model';
import { BookService } from '../../services/books.service';
import { AuthUtils } from 'src/app/utils/auth-utils';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  isLoading = true;
  isErrorLoading = false;
  isAdmin = false;

  pageTitle = 'Books';

  listFilter: any = {};
  dataSource: any = [];
  displayedColumns = ['img', 'id', 'name', 'author', 'ean', 'price', 'stock', 'buy'];

  @Output()
  bookOut = new EventEmitter();

  constructor(
    private bookService: BookService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.isErrorLoading = !(this.isLoading = true);
    this.isAdmin = AuthUtils.isAdmin(),
    this.bookService.getBooks().subscribe(books => {
      this.dataSource = books;
      this.isLoading = false;
    }, () => this.isLoading = !(this.isErrorLoading = true));
  }


  applyFilter(filterValue: string): void {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

  buyBook(book: Book): void {
    this.bookOut.emit(book);
    this.router.navigate(['checkout']);
  }

}


