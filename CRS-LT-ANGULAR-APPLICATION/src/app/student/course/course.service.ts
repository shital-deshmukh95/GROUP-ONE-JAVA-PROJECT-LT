import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../student';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
 
  url : string='http://javafulstack-59.alchemycloud.co.in:8092/'

  constructor(private http :HttpClient ) { }


/**
 * 
 * @param studentId 
 * @returns 
 */
  viewRegisteredCourses(studentId:string):Observable<any>{

   var subUrl = this.url + 'viewRegisteredCourses?studentId='+studentId;
   const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
   return this.http.get<any>(subUrl,httpOptions);  
 
 }

/**
 * 
 * @param studentId 
 * @param courseCode 
 * @returns 
 */
 dropCourse(studentId: string, courseCode: string) {
  console.log('courseCode **********************');
   console.log(courseCode);
   console.log(studentId);
  
  var subUrl = this.url + 'dropCourse?courseCode='+ courseCode +'&studentId='+studentId;
   const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
   return this.http.delete<any>(subUrl,httpOptions); 
}


viewAvailableCoursesList(studentId: string) {
  
  var subUrl = this.url + 'courses?studentId='+studentId;
  const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
  return this.http.get<any>(subUrl,httpOptions)
}


makePayment(studentId: string) {
  
  var subUrl = this.url + 'makePayment?studentId='+studentId;
  const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
  return this.http.post<any>(subUrl,httpOptions)
}


addCourse(courseCode: string, studentId: string) {
  
  var subUrl = this.url + 'addCourse?courseCode='+ courseCode +'&studentId='+studentId;
  const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
  return this.http.post<any>(subUrl,httpOptions)
}

getStudent(studentId: string) :Observable<any>{
  
  var subUrl = this.url + 'getById?studentId='+studentId;
  const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
  return this.http.get<any>(subUrl,httpOptions);
}



}
