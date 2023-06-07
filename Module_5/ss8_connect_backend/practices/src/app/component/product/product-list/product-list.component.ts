import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {Product} from '../../../model/product';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.productService.getAll().subscribe(next => {
      this.products = next;
    });
  }

  remove(id: number) {
    this.productService.removeById(id).subscribe(() => {
      this.ngOnInit();
    });
  }
}
