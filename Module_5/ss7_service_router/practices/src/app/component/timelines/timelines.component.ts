import {Component, OnInit} from '@angular/core';
import {DateUltiService} from '../../service/date-ulti.service';

@Component({
  selector: 'app-timelines',
  templateUrl: './timelines.component.html',
  styleUrls: ['./timelines.component.css']
})
export class TimelinesComponent implements OnInit {
  output = '';

  constructor(private dateUltiService: DateUltiService) {
  }

  ngOnInit(): void {
  }

  onChange(value) {
    this.output = this.dateUltiService.getDiffToNow(value);
  }

}
