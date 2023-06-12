import {Component, OnInit} from '@angular/core';
import {Employee} from '../../model/employee';
import {Router} from '@angular/router';
import {EmployeeService} from '../../service/employee-service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employee: Employee [] = [];
  deleteEmployeeId = 0;
  check = true;
  p = 1;

  constructor(private employeeService: EmployeeService, private router: Router) {
    this.employeeService.getAll().subscribe(next => {
      this.employee = next;
    });
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.employeeService.getAll().subscribe(next => {
      this.employee = next;
    });
  }

  changeDeleteId(employee) {
    this.deleteEmployeeId = employee;
  }

  doDelete(deleteEmployeeId: number) {
    this.employeeService.deleteEmployee(deleteEmployeeId).subscribe(next => {
      alert('Delete Employee thành công');
      this.getAll();
    });
  }

  search(key: any, field: string) {
    if (key === null) {
      return this.router.navigateByUrl('employee/list');
    }
    switch (field) {
      case 'id':
        this.employeeService.searchEmployeeById(key).subscribe(next => {
          this.employee = next;
        });
        break;
      case 'name':
        this.employeeService.searchEmployeeByName(key).subscribe(next => {
          this.employee = next;
        });
        break;
    }

  }

  sortById(): boolean {
    console.log(this.check + '0');
    if (this.check === true) {
      this.employeeService.sortEmployeeByIdAsc().subscribe(next => {
        this.employee = next;
      });
      this.check = false;
      return this.check;
    } else if (this.check === false) {
    }
    {
      this.employeeService.sortEmployeeByIdDsc().subscribe(next => {
        this.employee = next;
      });
      this.check = true;
      return this.check;
    }
  }
}
