
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Student } from 'src/app/student/student';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {



  constructor(private http:HttpClient) { }


/**
 * 
 * @param customer 
 * @returns 
 */
 register(student:Student):Observable<Student>{
  
  const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
  return this.http.post<Student>('http://javafulstack-59.alchemycloud.co.in:8094/register',student,httpOptions);  

}

  

  
}
