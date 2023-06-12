import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {EducationLevel} from '../model/education-level';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EducationService {

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<EducationLevel[]> {
    return this.httpClient.get<EducationLevel[]>('http://localhost:3000/education/');
  }
}
