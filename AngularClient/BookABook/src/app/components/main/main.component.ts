import { Component, OnInit } from '@angular/core';
import { AuthUtils } from 'src/app/utils/auth-utils';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  user = AuthUtils.getUsername();

  isAdmin = false;

  constructor() { }

  ngOnInit(): void {
    this.isAdmin = AuthUtils.isAdmin();
  }

}
