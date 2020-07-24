import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthUtils } from 'src/app/utils/auth-utils';

@Component({
  selector: 'app-not-found',
  templateUrl: './not-found.component.html',
  styleUrls: ['./not-found.component.css']
})
export class NotFoundComponent implements OnInit {

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {

  }

  return(): void  {
      this.router.navigate(['login']);
  }

}
