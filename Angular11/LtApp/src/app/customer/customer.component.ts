import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from './customer-service.service';
import { Customer } from '../mycomponent/customer';
@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  //getData:any ;
  custArray: Array<Customer> = new Array();
  model = new Customer(0,'', 0);



  constructor(private _httpService: CustomerServiceService) {
    this.getCustomerDetails();
   }

  ngOnInit(): void {
  }

  // get customer list 
  getCustomerDetails(){
  this._httpService.getCustomerDetails().subscribe((res : any)=>{
             console.log(res);
             this.custArray = res;
  });
  }
//add customer 

createCustomer(){
  console.log("customer creation here-->");
      try {
  
        // Add customer in Customer Array using push event.
        //this.custArray.push(new Customer(this.model.id,this.model.name, this.model.age));
        console.log(JSON.stringify(this.custArray));
       var max : number = 0;
        this.custArray.forEach(element => {
          if(element.id>max){
            max=element.id;
           console.log("MAx in loop :"+ max)
          }
        });

       this._httpService.addCustomer(new Customer(max+1,this.model.name, this.model.age)).subscribe((res : Customer)=>{
      
      this.getCustomerDetails();
       });
        
  
      } catch (err) {
  
        console.log("customer creation here-->" + err);
  
      }


}
//delete customer 


deleteCustomer(id:number){
  console.log("deleteCustomer Id"+ id);
  this._httpService.deleteCustomer(id).subscribe((res:number)=>{  console.log(res);
  });
  // list refresh
   this.getCustomerDetails();
}



/// select Customer 
selectValue(id:number){
  this._httpService.getCustomerBy(id).subscribe((res:Customer)=>{
 this.model.name=res.name;
  this.model.age=res.age;
  this.model.id=res.id;
  });
 
}


editCustomer(){
this._httpService.editCustomer(this.model,this.model.id).subscribe((res:Customer)=>{
   // this.model.name=res.name;
    // this.model.age=res.age;
     //this.custArray[this.model.id].name=res.name;
     //this.custArray[this.model.id].age= res.age
   
     });
 

   this.getCustomerDetails();

}


}
