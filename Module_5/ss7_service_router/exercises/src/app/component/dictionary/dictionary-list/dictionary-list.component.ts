import {Component, OnInit} from '@angular/core';
import {DictionaryService} from '../../../service/dictionary.service';
import {Dictionary} from '../../../model/dictionary';
import {Router} from '@angular/router';

@Component({
  selector: 'app-dictionary-list',
  templateUrl: './dictionary-list.component.html',
  styleUrls: ['./dictionary-list.component.css']
})
export class DictionaryListComponent implements OnInit {
  dictionaries: Dictionary[] = [];

  constructor(
    private dictionayService: DictionaryService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.dictionaries = this.dictionayService.dictionaries;
  }

  showDetail() {
  this.router.navigateByUrl('/dictionary/:id');
  }
}
