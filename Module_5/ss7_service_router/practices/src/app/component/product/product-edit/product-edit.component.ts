import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {id} from 'date-fns/locale';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  product: any;

  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
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
      }
    );
  }

  submit() {
    const product = this.productForm.value;
    this.productService.editProduct(product);
    this.productForm.reset();
    this.router.navigateByUrl('/product/list');
  }

}
