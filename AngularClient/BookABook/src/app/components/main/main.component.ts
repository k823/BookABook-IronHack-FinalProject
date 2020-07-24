import { Component, OnInit } from '@angular/core';
import { AuthUtils } from 'src/app/utils/auth-utils';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  user = AuthUtils.getUsername();

  isAdmin = false;

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
    this.router.navigate(['home']);
    this.isAdmin = AuthUtils.isAdmin();
  }

}
