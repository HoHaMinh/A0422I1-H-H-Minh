import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {EmployeeService} from '../../service/employee-service';
import {PositionService} from '../../service/position.service';
import {EducationService} from '../../service/education.service';
import {Employee} from '../../model/employee';
import {EmployeePosition} from '../../model/employee-position';
import {EducationLevel} from '../../model/education-level';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
  employee?: Employee;
  position: EmployeePosition[];
  education: EducationLevel[];

  employeeForm: FormGroup = new FormGroup({
    id: new FormControl(),
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
    private route: Router,
    private activatedRoute: ActivatedRoute,
    private employeeService: EmployeeService,
    private positionService: PositionService,
    private educationService: EducationService
  ) {
  }

  ngOnInit(): void {
    this.getEmployee();
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

  getEmployee() {
    this.activatedRoute.paramMap.subscribe(next => {
      const id = next.get('id');
      this.employeeService.getEmployeeById(id).subscribe(next => {
        this.employee = next;
      });
      this.employeeForm.get('id')?.setValue(id);
    });
  }

  updateEmployee() {
    const employee = this.employeeForm.value;
    this.employeeService.editEmployee(employee.id, employee).subscribe(next => {
      alert('Update thành công');
      this.route.navigateByUrl('/employee/list');
    });
  }

}
