import { Component, OnInit } from '@angular/core';
import { UserComponent } from 'src/app/user/user.component';
import { Course } from '../course/course';
import { CourseService } from '../course/course.service';

@Component({
  selector: 'app-view-available-courses',
  templateUrl: './view-available-courses.component.html',
  styleUrls: ['./view-available-courses.component.css']
})
export class ViewAvailableCoursesComponent implements OnInit {

  //studentId:string ='19';
  studentId=UserComponent.student.studentId;
  viewAvailableCourses: Array<Course> = new Array();


 course =new  Course('','','',0,0);

  constructor(private _httpService: CourseService) { }

  ngOnInit(): void {
    this.viewAvailableCoursesList(this.studentId);
  }

  viewAvailableCoursesList(studentId: string) {
    this._httpService.viewAvailableCoursesList(studentId).subscribe((rel:any)=>{
       this.viewAvailableCourses=rel;

    });
}

}
