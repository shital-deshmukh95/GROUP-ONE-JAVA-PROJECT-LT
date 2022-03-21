import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class MyserviceService {

  constructor(private http:HttpClient) { }


  // define the http get meathod to call Web API 
  // for fetch the details of User
  
  getUserDetails(): Observable<any> {
    return this.http.get
      ('http://localhost:7000/users');         
  }
  

  
  //Post put delete 
  
}
