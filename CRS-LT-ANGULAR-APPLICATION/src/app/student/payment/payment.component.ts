import { Component, Input, OnInit } from '@angular/core';
import { UserComponent } from 'src/app/user/user.component';
import { Course } from '../course/course';
import { CourseComponent } from '../course/course.component';
import { CourseService } from '../course/course.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  // studentId:string ='19';
  studentId=UserComponent.student.studentId;
  totalFee:number =0;
  
  listOfEnrolledCourses: Array<Course> = new Array();
  course =new  Course('','','',0,0);

  constructor(private _httpService: CourseService) { }

  ngOnInit(): void {
    this.viewRegisteredCourses(this.studentId);
  }

  viewRegisteredCourses(studentId: string) {
    this._httpService.viewRegisteredCourses(studentId).subscribe((rel:any)=>{
       this.listOfEnrolledCourses=rel;
       this.listOfEnrolledCourses.forEach(element => {
        this.totalFee = this.totalFee + element.courseFee;
         
       });
    });
}
 

  makePayment(){
    debugger
    console.log(this.studentId);

 this._httpService.makePayment(this.studentId).subscribe((rel:any)=>{
       console.log(rel);//payment successfull message need to bind 

    });

  }
}
