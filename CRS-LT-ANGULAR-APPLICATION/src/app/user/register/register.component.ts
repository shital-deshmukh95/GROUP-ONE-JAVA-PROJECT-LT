import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/student/student';
import { RegisterService } from './register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  student = new Student('','','','','','','');



  constructor(private _httpService : RegisterService) { }

  ngOnInit(): void {
  }


  register(){
this.student.studentId='E0102';
this._httpService.register(this.student).subscribe((rel:any)=>{

console.log(rel);

});


  }
}
