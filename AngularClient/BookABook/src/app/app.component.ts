import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { AuthUtils } from './utils/auth-utils';
export const ApiURL = 'https://transformers-crm-service.herokuapp.com';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'BookABook';

  constructor(private router: Router){

  }
  ngOnInit(): void {
    if (!AuthUtils.isLogged()){
      this.router.navigate(['login']);
    }
  }

}
