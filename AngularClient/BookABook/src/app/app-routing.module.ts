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
        path: 'books',
        component: BooksComponent,
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
        path: 'accounts',
        component: AccountsComponent
      },
      {
        path: '**',
        component: MainComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
