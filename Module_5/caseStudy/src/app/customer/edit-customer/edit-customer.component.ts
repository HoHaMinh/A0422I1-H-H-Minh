import {Component, OnInit} from '@angular/core';
import {TypeCustomer} from '../../model/type-customer';
import {Customer} from '../../model/customer';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {CustomerService} from '../../service/customerService';
import {TypeCustomerService} from '../../service/typeCustomerService';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  customer: Customer;
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
    private activatedRoute: ActivatedRoute,
    private typeCustomerService: TypeCustomerService
  ) {
  }

  ngOnInit(): void {
    this.getCustomer();
    this.getAllTypeCustomer();
  }

  getAllTypeCustomer() {
    this.typeCustomerService.getAll().subscribe(next => {
      this.typeCustomer = next;
    });
  }

  getCustomer() {
    this.activatedRoute.paramMap.subscribe(next => {
      const id = next.get('id');
      this.customerService.getCustomerById(id).subscribe(next => {
        this.customer = next;
        console.log(this.customer);
      });
    });
  }

  updateCustomer() {
    const customer = this.customerForm.value;
    console.log(customer);
    this.customerService.editCustomer(customer.id, customer).subscribe(next => {
      alert('Update thành công');
      this.route.navigateByUrl('/customer/list');
    });
  }
}
