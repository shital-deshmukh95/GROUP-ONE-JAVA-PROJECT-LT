import { Component, OnInit } from '@angular/core';
import { UserComponent } from 'src/app/user/user.component';
import { Course } from '../course/course';
import { CourseService } from '../course/course.service';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {

  courseCode:string = '';
  // studentId:string = '';
  studentId=UserComponent.student.studentId;
  constructor(private _httpService: CourseService) {
    
   }

  ngOnInit(): void {
  }

  addCourse(){
       this._httpService.addCourse(this.courseCode,this.studentId).subscribe((rel:any)=>{
    console.log(rel);
     });
  }


  

}
