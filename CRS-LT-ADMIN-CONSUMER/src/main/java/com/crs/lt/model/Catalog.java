package com.crs.lt.model;




public class Catalog {

private String courseCode;
private String courseName;
private String description;

public Catalog() {
super();
}



public Catalog(String courseCode, String courseName, String description) {
super();
this.courseCode = courseCode;
this.courseName = courseName;
this.description = description;
}



public String getCourseCode() {
return courseCode;
}



public void setCourseCode(String courseCode) {
this.courseCode = courseCode;
}



public String getCourseName() {
return courseName;
}



public void setCourseName(String courseName) {
this.courseName = courseName;
}



public String getDescription() {
return description;
}



public void setDescription(String description) {
this.description = description;
}



@Override
public String toString() {
return "Catalog [courseCode=" + courseCode + ", courseName=" + courseName + ", description=" + description
+ "]";
}


}