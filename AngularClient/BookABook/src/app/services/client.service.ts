import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Client } from '../models/client.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private urlEndpoint = 'https://clients-bookabook.herokuapp.com/';

  httpHeaders = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  constructor(
    private http: HttpClient
    ) { }

    getClients(): Observable<Client[]> {
      return this.http.get<Client[]>(this.urlEndpoint);
    }
}
