import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-caculator',
  templateUrl: './caculator.component.html',
  styleUrls: ['./caculator.component.css']
})
export class CaculatorComponent implements OnInit {
  number1 = 0;
  number2 = 0;
  result: number;
  mess: string;

  constructor() {
  }

  ngOnInit(): void {
  }

  sum(number1, number2) {
    this.result = number1 + number2;
  }

  minus(number1, number2) {
    this.result = number1 - number2;
  }

  multiplied(number1, number2) {
    this.result = number1 * number2;
  }

  divide(number1, number2) {
    if (number2 === 0) {
      this.result = null;
      this.mess = 'Can not divide by zero';
    } else {
      this.result = number1 / number2;
    }
  }
}
