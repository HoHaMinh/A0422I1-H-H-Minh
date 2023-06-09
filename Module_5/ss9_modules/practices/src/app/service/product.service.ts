import {Injectable} from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private API = 'http://localhost:3000/product';

  constructor(private httpClient: HttpClient) {
  }

  getAll() {
    return this.httpClient.get<Product[]>(`${this.API}`);
  }

  saveProduct(product: Product): Observable<Product> {
    return this.httpClient.post<Product>(`${this.API}`, product);
  }

  editProduct(product: Product): Observable<Product> {
    const index = product.id;
    if (index != null) {
      return this.httpClient.put<Product>(`${this.API}/${index}`, product);
    }
  }

  findProductById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(`${this.API}/${id}`);
  }

  removeById(id: number): Observable<Product> {
    return this.httpClient.delete<Product>(`${this.API}/${id}`);
  }
}
