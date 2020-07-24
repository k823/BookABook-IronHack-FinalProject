import { Component, OnInit, OnDestroy, ChangeDetectorRef } from '@angular/core';
import { MediaMatcher } from '@angular/cdk/layout';
import { Router } from '@angular/router';
import { AuthUtils } from 'src/app/utils/auth-utils';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnDestroy {

  display = false;

  constructor(
    changeDetectorRef: ChangeDetectorRef,
    media: MediaMatcher,
    private router: Router
  ) {
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    // tslint:disable-next-line: deprecation
    this.mobileQuery.addListener(this._mobileQueryListener);
    this.display = AuthUtils.isAdmin();
  }

  mobileQuery: MediaQueryList;

  fillerNavAdmin = [
    {
      name: 'Home',
      route: 'home',
      icon: 'home',
      display: this.display
    },
    {
      name: 'Clients',
      route: 'clients',
      icon: 'people_alt',
      display: this.display
    },
    {
      name: 'Sales',
      route: 'sales',
      icon: 'receipt',
      display: this.display
    },
    {
      name: 'Accounts',
      route: 'accounts',
      icon: 'card_giftcard',
      display: this.display
    },
    {
      name: 'Books',
      route: 'books',
      icon: 'import_contacts',
      display: this.display
    },
    {
      name: 'Dashboard',
      route: 'dashboard',
      icon: 'leaderboard',
      display: this.display
    },
    {
      name: 'Point of Sale',
      route: 'pos',
      icon: 'point_of_sale',
      display: this.display
    }
  ];

  fillerNavCommon = [
    {
      name: 'Home',
      route: 'home',
      icon: 'home',
      display: this.display
    },
    {
      name: 'Books',
      route: 'books',
      icon: 'import_contacts',
      display: this.display
    },
    {
      name: 'Point of Sale',
      route: 'pos',
      icon: 'point_of_sale',
      display: this.display
    }
  ];

  // tslint:disable-next-line: variable-name
  private _mobileQueryListener: () => void;

  shouldRun = true;

  ngOnDestroy(): void {
    // tslint:disable-next-line: deprecation
    this.mobileQuery.removeListener(this._mobileQueryListener);
  }

  logout(): void {
    AuthUtils.logout(this.router);
  }


}
