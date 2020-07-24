import { Component, OnInit } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { AccountService } from '../../services/account.service';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit {

  isLoading = true;
  isErrorLoading = false;
  isAdmin = false;

  pageTitle = 'Accounts';

  listFilter: any = {};
  dataSource: any = [];
  displayedColumns = ['id', 'ownerId', 'ownerName', 'credit', 'isPremium', 'createdAt'];

  private httpHeaders = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  constructor(
    private accountService: AccountService
  ) { }

  ngOnInit(): void {
    this.isErrorLoading = !(this.isLoading = true);
    // this.isAdmin = AuthUtils.isAdmin();
    this.accountService.getAccounts().subscribe(accounts => {
      this.dataSource = accounts;
      this.isLoading = false;
    }, () => this.isLoading = !(this.isErrorLoading = true));
  }


  applyFilter(filterValue: string): void {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }


}
