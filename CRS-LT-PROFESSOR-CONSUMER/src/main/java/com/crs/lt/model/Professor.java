package com.crs.lt.model;


public class Professor  {

	
	private String professorID;


	private String department;

	
	private String designation;
	
//	@Transient
//	public  String address;
//	
//	@Transient
//	public  String gender;
//	
//	@Transient
//	public  String name;
//	
//	@Transient
//	public  String password;
//	
//	@Transient
//	public  String role="PROFESSOR";

	public Professor() {
		super();
	}

	

	

	public String getProfessorID() {
		return professorID;
	}
	public void setProfessorID(String professorID) {
		this.professorID = professorID;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Professor [professorID=" + professorID + ", department=" + department + ", designation=" + designation
				+ "]";
	}


}
