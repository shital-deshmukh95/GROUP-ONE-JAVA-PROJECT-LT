import { Component, OnInit } from '@angular/core';
import { UserComponent } from 'src/app/user/user.component';
import { CourseService } from '../course/course.service';
import { ViewGreadCard } from '../view-grade-card';

@Component({
  selector: 'app-view-gade-card',
  templateUrl: './view-gade-card.component.html',
  styleUrls: ['./view-gade-card.component.css']
})
export class ViewGadeCardComponent implements OnInit {

  //studentId ='19;'
  studentId=UserComponent.student.studentId;
  listOfGread :Array<ViewGreadCard>=[];
  viewGreadCard =  new ViewGreadCard('','','');

  constructor(private _httpService: CourseService) { }

  ngOnInit(): void {
  }

  viewGreadCardForStudent() {
    this._httpService.viewAvailableCoursesList(this.studentId).subscribe((rel:any)=>{
       this.listOfGread=rel;// student data 
    });
}




}
