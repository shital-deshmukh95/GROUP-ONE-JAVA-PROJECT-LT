import { Component, OnInit } from '@angular/core';
import { CourseService } from '../student/course/course.service';
import { Student } from '../student/student';
import { User } from './user';
import { UserServiceService } from './user-service.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
   static student = new Student('','','','','','','');
   loginMessage:any ='shital';
  user = new User('','','');
  loginStatus = false;
 // static student: any;
  


  constructor(private _httpService :UserServiceService,private _httpCourseService :CourseService) { }

  ngOnInit(): void {
  }

  //Login
login():any{
  console.log('USer Id' + this.user.userId );
  console.log('USer Id' + this.user.password );
  this._httpService.login(this.user.userId, this.user.password).subscribe((rel :any)=>{
        // this.loginMessage= result;
        if(UserServiceService.loginStatus){
       
          this.loginMessage='Login successful '
          this.loginStatus=UserServiceService.loginStatus;
         this._httpCourseService.getStudent(this.user.userId).subscribe((rel :any)=>{
          
          UserComponent.student=rel;
        console.log(rel);

         });
        }
       
    

  console.log('student.studentID'+UserComponent.student.studentId);
  console.log(this.loginMessage);
  console.log(this.loginStatus);
  return  this.loginStatus;
});
}//login closing


// login():boolean{
//   this._httpService.sendMsz(this.user.userId, this.user.password).subscribe((rel :any)=>{


    
//   });
//return true;

}//class closing





