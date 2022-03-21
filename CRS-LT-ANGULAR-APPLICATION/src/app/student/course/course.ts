export class Course {
    public courseCode :string;
    public courseName :string;
    public instructorId  :string;
    public availableSeats :number;
    public courseFee :number;

  constructor(courseCode:string ,courseName:string , instructorId : string,availableSeats :number,courseFee:number)
  {
    
    this.courseCode=courseCode;
    this.courseName =courseName;
    this.instructorId=instructorId;
    this. availableSeats=availableSeats;
    this.courseFee=courseFee;

  }

}
