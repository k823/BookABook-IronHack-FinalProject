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
        path: 'main',
        component: MainComponent
      },
      {
        path: 'accounts',
        component: AccountsComponent
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
