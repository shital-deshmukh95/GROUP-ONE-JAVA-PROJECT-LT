import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from '../mycomponent/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  constructor(private http:HttpClient) { }
/**
 * getCustomerDetails
 * @returns 
 */
  getCustomerDetails(): Observable<any> {
    return this.http.get('http://localhost:7100/customer/list');         
  }

/**
 * 
 * @param customer 
 * @returns 
 */
addCustomer(customer:Customer):Observable<Customer>{
  
  const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
  return this.http.post<Customer>('http://localhost:7100/customer/create',customer,httpOptions);  

}


deleteCustomer(id:number):Observable<number>{
  
  console.log("Id inside service" + id);
//let url: string = 'http://localhost:7100/customer/delete/'+id;


  return this.http.delete<number>('http://localhost:7100/customer/delete/'+id);
 // http://localhost:7100/customer/delete/14
}

//getCustomerBy
getCustomerBy(id:number):Observable<Customer>{
 
let url: string = 'http://localhost:7100/customer/delete/'+id;

const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
  return this.http.get<Customer>(url,httpOptions);
 // http://localhost:7100/customer/delete/14
}

// editCustomer
editCustomer(customer:Customer,id:number):Observable<Customer>{

  const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };
  return this.http.put<Customer>('http://localhost:7100/customer/update/'+id,customer,httpOptions);

}

}
