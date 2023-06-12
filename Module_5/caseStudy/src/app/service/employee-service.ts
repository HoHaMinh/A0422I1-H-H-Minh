import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Employee} from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>('http://localhost:3000/employee/');
  }

  addEmployee(employee: Employee): Observable<any> {
    return this.httpClient.post('http://localhost:3000/employee/', employee);
  }

  editEmployee(id: any, employee: any): Observable<any> {
    return this.httpClient.put('http://localhost:3000/employee/' + id, employee);
  }

  deleteEmployee(id: any): Observable<any> {
    return this.httpClient.delete('http://localhost:3000/employee/' + id);
  }

  getEmployeeById(id: any): Observable<Employee> {
    return this.httpClient.get<Employee>('http://localhost:3000/employee/' + id);
  }

  searchEmployeeById(id: any): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>('http://localhost:3000/employee?id_like=' + id);
  }

  searchEmployeeByName(name: any): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>('http://localhost:3000/employee?name_like=' + name);
  }

  sortEmployeeByIdAsc(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>('http://localhost:3000/employee?_sort=id&_order=asc');
  }

  sortEmployeeByIdDsc(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>('http://localhost:3000/employee?_sort=id&_order=desc');
  }
}
