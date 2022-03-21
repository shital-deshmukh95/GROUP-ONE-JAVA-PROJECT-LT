import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';


import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { StudentComponent } from './student/student.component';
import { ProfessorComponent } from './professor/professor.component';
import { CourseComponent } from './student/course/course.component';
import { RegisterComponent } from './user/register/register.component';
import { CrsFooterComponent } from './crs-footer/crs-footer.component';
import { ViewAvailableCoursesComponent } from './student/view-available-courses/view-available-courses.component';

import { AddCourseComponent } from './student/add-course/add-course.component';
import { PaymentComponent } from './student/payment/payment.component';
import { ViewGadeCardComponent } from './student/view-gade-card/view-gade-card.component';



@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    UserComponent,
    StudentComponent,
    ProfessorComponent,
    CourseComponent,
    RegisterComponent,
    CrsFooterComponent,
    ViewAvailableCoursesComponent,
    
    AddCourseComponent,
    PaymentComponent,
    ViewGadeCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
