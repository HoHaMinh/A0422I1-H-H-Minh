import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DictionaryListComponent} from './component/dictionary/dictionary-list/dictionary-list.component';
import {DictionaryDetailComponent} from './component/dictionary/dictionary-detail/dictionary-detail.component';


const routes: Routes = [
  {
    path: 'dictionary',
    component: DictionaryListComponent
  },
  {
    path: 'dictionary/:id',
    component: DictionaryDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
