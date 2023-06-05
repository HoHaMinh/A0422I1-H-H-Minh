import { Injectable } from '@angular/core';
import {Dictionary} from '../model/dictionary';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
dictionaries: Dictionary[] = [
  {
    id: 1,
    word: 'commercial',
    meaning: 'Tính từ\n' +
      '[thuộc] buôn bán, [thuộc] thương mại, [thuộc] thương nghiệp, [thuộc] mậu dịch\n' +
      'có hiệu quả kinh tế, có lời\n' +
      'mang tính thương mại\n' +
      'để quảng cáo (radio, tivi)\n' +
      'Danh từ\n' +
      'buổi phát thanh quảng cáo; buổi truyền hình quảng cáo'
  },
  {
    id: 2,
    word: 'supplier',
    meaning: 'Danh từ\n' +
      '(cách viết khác suppliers số nhiều)\n' +
      'hãng cung ứng; nhà cung ứng'
  },
  {
    id: 3,
    word: 'term',
    meaning: 'Danh từ\n' +
      'hạn, kỳ hạn; nhiệm kỳ\n' +
      'học kỳ\n'
  }
];
  constructor() { }

  findWordById(id: number) {
    return this.dictionaries.find(item => item.id === id);
  }

  findWordByName(word: string) {
    return this.dictionaries.find(item => item.word === word);
  }
}
