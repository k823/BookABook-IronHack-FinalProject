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
  isAdmin: boolean;
  mySubscription: any;


  pageTitle = 'Books';

  listFilter: any = {};
  dataSource: any = [];
  displayedColumns = [];

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
    this.displayedColumns = this.checkDisplayedColumns();
  }


  // tslint:disable-next-line: use-lifecycle-interface
  ngOnDestroy(): void {
    if (this.mySubscription) {
      this.mySubscription.unsubscribe();
    }
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

  editBook(book: Book): void {
    this.bookOut.emit(book);
    this.router.navigate(['books/create']);
  }

  delete(id: number): void {
    this.bookService.delete(id).subscribe(res => {
      this.router.navigated = false;
    }, err => {
      this.router.navigated = false;
    });
  }

  checkDisplayedColumns(): string[] {
    console.log(this.isAdmin);
    // tslint:disable-next-line: max-line-length
    return this.displayedColumns = this.isAdmin ? ['img', 'id', 'name', 'author', 'ean', 'price', 'stock', 'edit', 'delete', 'buy'] : ['img', 'name', 'author', 'ean', 'price', 'stock', 'buy'];
  }

}


