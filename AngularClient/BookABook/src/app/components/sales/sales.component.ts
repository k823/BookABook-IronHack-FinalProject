import { Component, OnInit } from '@angular/core';
import { SalesService } from '../../services/sales.service';
import { AuthUtils } from 'src/app/utils/auth-utils';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sales',
  templateUrl: './sales.component.html',
  styleUrls: ['./sales.component.css']
})
export class SalesComponent implements OnInit {

  isLoading = true;
  isErrorLoading = false;
  isAdmin = false;

  pageTitle = 'Sales';

  listFilter: any = {};
  dataSource: any = [];
  displayedColumns = ['id', 'client', 'product', 'paymentMethod', 'discount', 'total', 'createdAt'];

  constructor(
    private salesService: SalesService,
    private router: Router
  ) { }

  ngOnInit(): void {
    if (!AuthUtils.isAdmin()) {
      this.router.navigate(['books']);
    }
    this.isErrorLoading = !(this.isLoading = true);
    // this.isAdmin = AuthUtils.isAdmin();
    this.salesService.getSales().subscribe(clients => {
      this.dataSource = clients;
      this.isLoading = false;
    }, () => this.isLoading = !(this.isErrorLoading = true));
  }


  applyFilter(filterValue: string): void {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

}
