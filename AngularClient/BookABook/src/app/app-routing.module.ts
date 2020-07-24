import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { MainComponent } from './components/main/main.component';
import { BooksComponent } from './components/books/books.component';
import { ClientsComponent } from './components/clients/clients.component';
import { SalesComponent } from './components/sales/sales.component';
import { AccountsComponent } from './components/accounts/accounts.component';
import { AuthUtils } from './utils/auth-utils';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { RegisterComponent } from './components/register/register.component';
import { PosComponent } from './components/pos/pos.component';
import { CreateBookComponent } from './components/create-book/create-book.component';


const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '',
    component: NavbarComponent,
    children: [
      {
        path: '',
        component: MainComponent,
      },
      {
        path: 'books',
        component: BooksComponent
      },
      {
        path: 'books/create',
        component: CreateBookComponent
      },
      {
        path: 'clients',
        component: ClientsComponent
      }
      ,
      {
        path: 'sales',
        component: SalesComponent
      },
      {
        path: 'home',
        component: MainComponent
      },
      {
        path: 'main',
        component: MainComponent
      },
      {
        path: 'accounts',
        component: AccountsComponent
      },
      {
        path: 'checkout',
        component: PosComponent
      }
    ]
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'not-found',
    component: NotFoundComponent
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
