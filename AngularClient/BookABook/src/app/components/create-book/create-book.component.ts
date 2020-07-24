import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Book } from 'src/app/models/book.model';
import { BookService } from 'src/app/services/books.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {

  bookForm: FormGroup;
  book: Book;
  fieldColspan = 5;
  pageTitle = 'Add new Book';

  constructor(
    private fb: FormBuilder,
    private bookService: BookService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.bookForm = this.fb.group({
      name: ['', Validators.required],
      author: ['', Validators.required],
      ean: ['', Validators.required],
      img: '',
      price: ['', Validators.required],
      stock: ['', Validators.required]
    });
  }

  createBook(): void {
    this.book = this.bookForm.value;
    this.book.img = 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fmaxcdn.icons8.com%2FShare%2Ficon%2FPrinting%2Fbook1600.png&f=1&nofb=1';
    console.log(this.book);
    this.bookService.create(this.book).subscribe(res => {
      this.router.navigate(['books']);
    }, err => {
      console.log(err);
      this.router.navigate(['books']);
    });
  }
}
