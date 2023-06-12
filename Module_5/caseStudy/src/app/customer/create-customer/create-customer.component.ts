import {Component, OnInit} from '@angular/core';
import {TypeCustomer} from '../../model/type-customer';
import {Customer} from '../../model/customer';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../service/customerService';
import {Router} from '@angular/router';
import {TypeCustomerService} from '../../service/typeCustomerService';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  customer?: Customer;
  typeCustomer: TypeCustomer[];

  customerForm: FormGroup = new FormGroup({
    id: new FormControl('', [Validators.required, Validators.pattern(/^KH-\d{4}$/)]),
    name: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(255)]),
    birthday: new FormControl('', [Validators.required]),
    idCard: new FormControl('', [Validators.required, Validators.minLength(9)]),
    gender: new FormControl(),
    // Validators.pattern(/^[[0][9][0|1][\d]{7}]$/,)]
    phone: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required]),
    address: new FormControl('', [Validators.required]),
    type: new FormControl('', [Validators.required])
  });

  constructor(
    private customerService: CustomerService,
    private route: Router,
    private typeCustomerService: TypeCustomerService
  ) {
  }

  ngOnInit(): void {
    this.getAllTypeCustomer();
  }

  getAllTypeCustomer() {
    this.typeCustomerService.getAll().subscribe(next => {
      this.typeCustomer = next;
    });
  }

  addCustomer() {
    this.customerService.addCustomer(this.customerForm.value).subscribe(next => {
      this.customerForm.reset();
      alert('Thêm Mới thành công');
      this.route.navigateByUrl('/customer/list');
    });
  }
}
