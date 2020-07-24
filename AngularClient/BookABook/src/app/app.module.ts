import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { MatTabsModule } from '@angular/material/tabs';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MaterialModule } from 'src/app/modules/material/material.module';
import { MainComponent } from './components/main/main.component';
import { BooksComponent } from './components/books/books.component';
import { ClientsComponent } from './components/clients/clients.component';
import { SalesComponent } from './components/sales/sales.component';
import { AccountsComponent } from './components/accounts/accounts.component';
import { BookService } from './services/books.service';
import { HttpClientModule } from '@angular/common/http';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { RegisterComponent } from './components/register/register.component';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    MainComponent,
    BooksComponent,
    ClientsComponent,
    SalesComponent,
    AccountsComponent,
    NotFoundComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatTabsModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MaterialModule,
    HttpClientModule
  ],
  providers: [
    BookService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
