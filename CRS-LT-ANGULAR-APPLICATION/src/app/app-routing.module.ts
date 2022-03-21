import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrsFooterComponent } from './crs-footer/crs-footer.component';
import { AddCourseComponent } from './student/add-course/add-course.component';
import { CourseComponent } from './student/course/course.component';
import { PaymentComponent } from './student/payment/payment.component';
import { StudentComponent } from './student/student.component';
import { ViewAvailableCoursesComponent } from './student/view-available-courses/view-available-courses.component';
import { ViewGadeCardComponent } from './student/view-gade-card/view-gade-card.component';
import { RegisterComponent } from './user/register/register.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  { path : '', redirectTo:'user', pathMatch:'full' },
  { path : 'user',component: UserComponent},
  { path : 'student',component: StudentComponent},
  { path : 'register',component: RegisterComponent},
  { path : 'viewAvailableCourses', component: ViewAvailableCoursesComponent},
  { path : 'viewRegisteredCourses', component: CourseComponent},
  { path : 'dropCourse', component: CourseComponent},
  { path : 'makePayment',component: PaymentComponent},
  { path : 'addCourse',component: AddCourseComponent},
  { path : 'viewGreadCard',component: ViewGadeCardComponent},
  
  
  
  { path : 'footer',component: CrsFooterComponent}
]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
