import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/models/client.model';
import { Book } from 'src/app/models/book.model';
import { ClientService } from 'src/app/services/client.service';
import { BookService } from 'src/app/services/books.service';
import { BasketProduct } from 'src/app/models/basketProduct.model';

@Component({
  selector: 'app-pos',
  templateUrl: './pos.component.html',
  styleUrls: ['./pos.component.css']
})
export class PosComponent implements OnInit {

  searchInput = 'Serach by EAN or Name '

  clients: Client[];
  books: Book[];
  search: [];
  bookSearchInput = '';
  clientSearchInput = '';
  client: { commercialName: 'Cliente Contado', fiscalName: 'Cliente Contado', nif: 'A00000000', defaultPayMethod: 'Efectivo' };
  basket: BasketProduct[] = [];
  total = 0;
  bookQty = 0;
  totalTax = 0;
  showPayment = false;
  showbooks = false;
  showClients = false;


  constructor(
    private bookService: BookService,
    private clientService: ClientService
  ) { }



  ngOnInit(): void {
    this.getData();
  }

  getData = () => {
    this.bookService.getBooks().subscribe(data => this.books = data);
    this.clientService.getClients().subscribe(data => this.clients = data);
  }

  addToBasket(book: Book): void {

    const basketCopy = [...this.basket];

    const basketbook: BasketProduct = {
      id: book.id,
      name: book.name,
      stock: book.stock,
      qty: 1,
      total: parseFloat(book.price.toFixed(2))
    };

    if (basketCopy.some(elm => elm.id === book.id)) {
      this.addQtyBasket(basketbook);
      return;
    }

    basketCopy.push(basketbook);
    this.basket = [...basketCopy];
    this.calculateTotal();
  }

  addQtyBasket(basketbook: BasketProduct): void {
    const basketCopy = [...this.basket];
    basketCopy.some(elem => elem.id === basketbook.id && (elem.qty += 1, elem.total += elem.total));
    this.calculateTotal();
  }

  subtractQtyBasket(book: BasketProduct): void {
    const basketCopy = [...this.basket];
    basketCopy.some(elem => elem.id === book.id && (elem.qty -= 1, elem.total -= elem.total));
    this.calculateTotal();
  }

  deleteBookBasket = book => {
    const basketCopy = [...this.basket];
    basketCopy.splice(basketCopy.indexOf(book), 1);
    this.basket = basketCopy;
    this.calculateTotal();
  }

  calculateTotal = () => {
    const basketCopy = [...this.basket];
    this.total = parseFloat(basketCopy.reduce((acum, elem) => acum + elem.total, 0).toFixed(2));
    this.bookQty = basketCopy.reduce((acum, elem) => acum + elem.qty, 0);
    this.basket = basketCopy;
  }

}
