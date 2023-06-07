import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer';
import {Router} from '@angular/router';
import {CustomerService} from '../../service/customerService';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customers: Customer [] = [];
  deleteCustomerId = 0;
  check = true;

  constructor(private customerService: CustomerService, private router: Router) {
    this.customerService.getAll().subscribe(next => {
      this.customers = next;
    });
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.customerService.getAll().subscribe(next => {
      this.customers = next;
    });
  }

  changeDeleteId(customer) {
    this.deleteCustomerId = customer;
  }

  doDelete(deleteCustomerId: number) {
    this.customerService.deleteCustomer(deleteCustomerId).subscribe(next => {
      alert('Delete Customer thành công');
      this.getAll();
    });
  }

  search(key: any, field: string) {
    if (key === null) {
      return this.router.navigateByUrl('customer/list');
    }
    switch (field) {
      case 'id':
        this.customerService.searchCustomerById(key).subscribe(next => {
          this.customers = next;
        });
        break;
      case 'name':
        this.customerService.searchCustomerByName(key).subscribe(next => {
          this.customers = next;
        });
        break;
    }

  }

  sortById() {
    if (this.check === true) {
      this.customerService.sortCustomerByIdAsc().subscribe(next => {
        this.customers = next;
      });
      this.check = false;
    } else if (this.check === false) {
    }
    {
      this.customerService.sortCustomerByIdDsc().subscribe(next => {
        this.customers = next;
      });
      this.check = true;
    }
  }
}
