import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {ProductService} from '../../service/product-service.service';
import {Category} from '../../model/category';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  category: Category[];

  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
    category: new FormControl()
  });

  constructor(private productService: ProductService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getAllCategory();
  }

  submit() {
    const product = this.productForm.value;
    this.productService.saveProduct(product).subscribe(() => {
      this.productForm.reset();
      this.ngOnInit();
      alert('Tạo thành công');
      this.router.navigateByUrl('product/list');
    });
  }

  getAllCategory() {
    this.productService.getAllCategory().subscribe(next => {
      this.category = next;
    });
  }
}
