import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
 url:string ='http://javafulstack-59.alchemycloud.co.in:8094/';
  constructor(private http:HttpClient) { }
 static loginStatus : boolean=false;


  


  login(userId:string,userPassword:string):Observable<any> { 
    var subUrl:string= this.url + 'login?userId='+ userId +'&password=' + userPassword ;
    return this.http.get(subUrl,{responseType:'text',  observe: 'response'}).pipe(map(data => {
         
         console.log("Here will be return response code Ex :200", data.status)
      if(data.status == 200){
        console.log("In if condition :200", data.status)
        UserServiceService.loginStatus=true;
      }

         return data.status
           }));
   }

}
