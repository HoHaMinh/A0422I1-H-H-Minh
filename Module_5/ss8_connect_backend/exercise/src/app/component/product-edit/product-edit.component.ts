import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ProductService} from '../../service/product-service.service';
import {Category} from '../../model/category';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  product: any;
  category: Category[];

  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
    category: new FormControl()
  });

  constructor(
    private productService: ProductService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const idEdit = +paramMap.get('id');
      this.product = this.productService.findProductById(idEdit);
      this.productForm.get('id')?.setValue(idEdit);
    });
    this.getAllCategory();
  }

  submit() {
    const product = this.productForm.value;
    this.productService.editProduct(product).subscribe(() => {
      this.productForm.reset();
    });
    this.ngOnInit();
    this.router.navigateByUrl('product/list');
  }

  getAllCategory() {
    this.productService.getAllCategory().subscribe(next => {
      this.category = next;
    });
  }

}
