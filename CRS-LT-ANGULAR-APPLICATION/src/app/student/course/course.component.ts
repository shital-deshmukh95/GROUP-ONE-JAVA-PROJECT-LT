import { Component, Input, OnInit } from '@angular/core';
import { UserComponent } from 'src/app/user/user.component';
import { Course } from './course';
import { CourseService } from './course.service';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
  studentId=UserComponent.student.studentId;

  listOfEnrolledCourses: Array<Course> = new Array();


 course =new  Course('','','',0,0);


  courseDroppedMessage: any = 'hjghkhk';


  courseDropped: any;
  constructor(private _httpService: CourseService ) { 
    this.studentId = UserComponent.student.studentId;
  }

 
  
  ngOnInit(): void {
    this.viewRegisteredCourses(this.studentId);
  }

  viewRegisteredCourses(studentId: string) {
    this._httpService.viewRegisteredCourses(studentId).subscribe((rel:any)=>{
       this.listOfEnrolledCourses=rel;

    });
}


  dropCourse(index:number): number {
    var courseCode=this.listOfEnrolledCourses[index].courseCode;
console.log(this.studentId+courseCode);
        this._httpService.dropCourse('E0101',courseCode) .subscribe((rel:any)=>{
          this.viewRegisteredCourses('E0101');
  
      });

    return 1;

  }



}
