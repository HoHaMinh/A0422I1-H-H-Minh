import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListCustomerComponent} from './customer/list-customer/list-customer.component';
import {CreateCustomerComponent} from './customer/create-customer/create-customer.component';
import {EditCustomerComponent} from './customer/edit-customer/edit-customer.component';


const routes: Routes = [
  // {path: '', component: FacilityListComponent},
  // {path: 'facility/create', component: FacilityCreateComponent},
  // {path: 'facility/edit/:id', component: FacilityEditComponent},
  {path: 'customer/list', component: ListCustomerComponent},
  {path: 'customer/create', component: CreateCustomerComponent},
  {path: 'customer/edit/:id', component: EditCustomerComponent},
  // {path: 'contact/list', component: ContactAppComponent},
  // {path: 'contact/create', component: ContactCreateComponent},
  // {path: 'contact/edit/:id', component: ContactEditComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
