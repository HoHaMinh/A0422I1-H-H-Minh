import {Component, OnInit} from '@angular/core';
import {DictionaryService} from '../../../service/dictionary.service';
import {ActivatedRoute, ParamMap} from '@angular/router';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  word: any;

  constructor(
    private dictionaryService: DictionaryService,
    private activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
        const id = +paramMap.get('id');
        this.word = this.dictionaryService.findWordById(id);
      }
    );
  }

}
