import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {User} from '../user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  users: User[];
  userDetail: User = undefined;

  constructor() {
  }

  ngOnInit(): void {
  }

  changeUser(user: User) {
    this.userDetail = user;
  }

  createUser(user: User) {
    this.users.push(user);
  }
}
