import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {EmployeePosition} from '../model/employee-position';

@Injectable({
  providedIn: 'root'
})
export class PositionService {

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<EmployeePosition[]> {
    return this.httpClient.get<EmployeePosition[]>('http://localhost:3000/position/');
  }
}
