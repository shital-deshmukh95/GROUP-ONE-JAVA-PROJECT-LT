import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './customer/customer.component';
import { HomeComponentComponent } from './home-component/home-component.component';
import { ModelcomponentComponent } from './modelcomponent/modelcomponent.component';

// Define the routes
const routes: Routes = [
  { path : '', redirectTo:'home', pathMatch:'full' },
  { path : 'home',component: HomeComponentComponent},
  { path : 'customer',component: CustomerComponent},
  { path : 'order',component: ModelcomponentComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
