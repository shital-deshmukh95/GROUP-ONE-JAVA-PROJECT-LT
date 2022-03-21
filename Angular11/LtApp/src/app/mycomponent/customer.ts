export class Customer {

    // properties 
	public id :number;
	public name:string;
	public age : number;


	// constructor(name:string, age : number){
	// 	this.name = name;
	// 	this.age = age;
	// }
	constructor(id:number ,name:string, age : number){
		this.id=id;
		this.name = name;
		this.age = age;

	}
}
