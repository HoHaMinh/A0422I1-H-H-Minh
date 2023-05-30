import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {User} from '../user';

@Component({
  selector: 'app-register-create',
  templateUrl: './register-create.component.html',
  styleUrls: ['./register-create.component.css']
})
export class RegisterCreateComponent implements OnInit {
  @Output() onCreate = new EventEmitter<User>();
  userCreate: User;
  register: FormGroup;
  countries: string[] = ['Da Nang', 'Quang nam', 'Hue'];
  constructor() {
  }

  ngOnInit(): void {
    this.register = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z0-9]+@[a-zA-Z0-9]+[.][a-zA-Z]+$')]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      confirmPassword: new FormControl('', [Validators.required, Validators.minLength(6)]),
      country: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required, Validators.min(19)]),
      gender: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required, Validators.pattern('^0084\d{9,10}$')])
    });
  }

  addUser(email: string, password: string, country: string, age: string, gender: string, phone: string) {
    this.userCreate = {
      email,
      password,
      country,
      age,
      gender,
      phone
    };
    this.onCreate.emit(this.userCreate);
  }
}
