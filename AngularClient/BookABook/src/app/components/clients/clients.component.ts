import { Component, OnInit } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { ClientService } from 'src/app/services/client.service';
import { AuthUtils } from 'src/app/utils/auth-utils';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  isLoading = true;
  isErrorLoading = false;
  isAdmin = false;

  pageTitle = 'Clients';

  listFilter: any = {};
  dataSource: any = [];
  displayedColumns = ['id', 'name', 'telNumber', 'email', 'address', 'zipCode', 'credit'];

  constructor(
    private clientService: ClientService,
    private router: Router
  ) { }

  ngOnInit(): void {
    if (!AuthUtils.isAdmin) {
      this.router.navigate(['books']);
    }
    this.isErrorLoading = !(this.isLoading = true);
    this.isAdmin = AuthUtils.isAdmin();
    this.clientService.getClients().subscribe(clients => {
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
