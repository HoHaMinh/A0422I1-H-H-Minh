import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {TypeCustomer} from '../model/type-customer';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TypeCustomerService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<TypeCustomer[]> {
    return this.httpClient.get<TypeCustomer[]>('http://localhost:3000/typeCustomer/');
  }
}
