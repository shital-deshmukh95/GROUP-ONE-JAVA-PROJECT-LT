// import { Component, OnInit } from '@angular/core';
// import { Customer } from './customer';
// import { MyserviceService } from './myservice.service';
// @Component({
//   selector: 'app-mycomponent',
//   templateUrl: './mycomponent.component.html',
//   styleUrls: ['./mycomponent.component.css']
// })
// export class MycomponentComponent implements OnInit {

//   getData:any ;
//   custArray: Array<Customer> = new Array();
//   lengthOfArray :number = 0;
//    model = new Customer(0,'', 0);//need to change this line
//    name :string ='';
//    age :number =0;
//    editIndex :number =0;
//   // define back model here 

 

//   constructor(private _httpService: MyserviceService) { }

//   ngOnInit(): void {
//   }
//   // define Customer Array as model to get values here 

  

//   createCustomer() {

//     console.log("customer creation here-->");
//     try {

//       // Add customer in Customer Array using push event.
//       this.custArray.push(new Customer(this.model.name, this.model.age));
//       console.log(JSON.stringify(this.custArray));
//       //var a=10/0;


//     } catch (err) {

//       console.log("customer creation here-->" + err);

//     }
//   }
// public selectValue(index :number){
//   debugger
//  this.model.name=this.custArray[index].name;
//  this.model.age=this.custArray[index].age;
// this.editIndex=index;
// }


// public editCustomer()
// {
// debugger
// this.custArray[this.editIndex].name=this.model.name;
// this.custArray[this.editIndex].age= this.model.age



 
//   }


//   public deleteCustomer(index :number){
//     console.log("Array Index " + index);
   
//  this.custArray = this.newArray(this.custArray ,index);
  

//   }

// public newArray(array: Array<Customer>,indexValue:number):Array<Customer>{
  
//   let newArray: Array<Customer> = new Array();
 
  
//   // define back model here 

//   let customer = new Customer('', 0);
 

//   for (let index = 0; index < array.length; index++) {

//     if(index != indexValue){
//       customer.age=array[index].age;
//       customer.name=array[index].name;

//      newArray.push(new Customer(customer.name, customer.age));

//     }



    
//   }
  


// return newArray;

// }


// //get USer from service
  
// getUser(){

//   this._httpService.getUserDetails().subscribe((res : any)=>{
//            console.log(res);
//            this.getData = res;

// });
// }






// }
