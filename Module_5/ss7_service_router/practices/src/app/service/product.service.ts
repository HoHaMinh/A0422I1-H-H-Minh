import {Injectable} from '@angular/core';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products: Product[] = [{
    id: 1,
    name: 'IPhone 12',
    price: 2400000,
    description: 'New'
  }, {
    id: 2,
    name: 'IPhone 11',
    price: 1560000,
    description: 'Like new'
  }, {
    id: 3,
    name: 'IPhone X',
    price: 968000,
    description: '97%'
  }, {
    id: 4,
    name: 'IPhone 8',
    price: 7540000,
    description: '98%'
  }, {
    id: 5,
    name: 'IPhone 11 Pro',
    price: 1895000,
    description: 'Like new'
  }];

  constructor() {
  }

  getAll() {
    return this.products;
  }

  saveProduct(product) {
    this.products.push(product);
  }

  editProduct(product) {
    const index = this.products.findIndex(x => x.id === product.id);
    if (index != null) {
      this.products[index] = product;
    }
  }

  findProductById(id: number) {
    return this.products.find(item => item.id === id);
  }

  removeById(id: number) {
    const idRemove = this.products.indexOf(this.findProductById(id));
    this.products.splice(idRemove, 1);
  }
}
