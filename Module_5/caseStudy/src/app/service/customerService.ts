import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>('http://localhost:3000/customers/');
  }

  addCustomer(customer: Customer): Observable<any> {
    return this.httpClient.post('http://localhost:3000/customers/', customer);
  }

  editCustomer(id: any, customer: any): Observable<any> {
    return this.httpClient.put('http://localhost:3000/customers/' + id, customer);
  }

  deleteCustomer(id: any): Observable<any> {
    return this.httpClient.delete('http://localhost:3000/customers/' + id);
  }

  getCustomerById(id: any): Observable<Customer> {
    return this.httpClient.get<Customer>('http://localhost:3000/customers/' + id);
  }

  searchCustomerById(id: any): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>('http://localhost:3000/customers?id_like=' + id);
  }

  searchCustomerByName(name: any): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>('http://localhost:3000/customers?name_like=' + name);
  }

  sortCustomerByIdAsc(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>('http://localhost:3000/customers?_sort=id&_order=asc');
  }

  sortCustomerByIdDsc(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>('http://localhost:3000/customers?_sort=id&_order=desc');
  }
}
