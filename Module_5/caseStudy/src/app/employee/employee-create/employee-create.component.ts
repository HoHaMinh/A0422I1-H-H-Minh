import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {EmployeeService} from '../../service/employee-service';
import {PositionService} from '../../service/position.service';
import {EducationService} from '../../service/education.service';
import {Employee} from '../../model/employee';
import {EmployeePosition} from '../../model/employee-position';
import {EducationLevel} from '../../model/education-level';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  employee?: Employee;
  position: EmployeePosition[];
  education: EducationLevel[];

  employeeForm: FormGroup = new FormGroup({
    id: new FormControl('', [Validators.required, Validators.pattern(/NV-\d{4}/)]),
    name: new FormControl('', [Validators.required, Validators.minLength(1), Validators.maxLength(255)]),
    birthday: new FormControl('', [Validators.required]),
    personCode: new FormControl('', [Validators.required, Validators.pattern(/[0-9]{9}/)]),
    phoneNumber: new FormControl('', [Validators.required, Validators.pattern(/090[0-9]{7}$/)]),
    email: new FormControl('', [Validators.required, Validators.pattern(/[a-z0-9]+@[a-z0-9]+\.com/)]),
    educationLevel: new FormControl('', [Validators.required]),
    position: new FormControl('', [Validators.required]),
    salary: new FormControl('', [Validators.required, Validators.min(1)]),
  });
  constructor(
    private employeeService: EmployeeService,
    private route: Router,
    private positionService: PositionService,
    private educationService: EducationService
  ) { }

  ngOnInit(): void {
    this.getAllPosition();
    this.getAllEducationLevel();
  }

  getAllPosition() {
    this.positionService.getAll().subscribe(next => {
      this.position = next;
    });
  }

  getAllEducationLevel() {
    this.educationService.getAll().subscribe(next => {
      this.education = next;
    });
  }

  addEmployee() {
    this.employeeService.addEmployee(this.employeeForm.value).subscribe(next => {
      this.employeeForm.reset();
      alert('Thêm Mới thành công');
      this.route.navigateByUrl('/employee/list');
    });
  }
}
