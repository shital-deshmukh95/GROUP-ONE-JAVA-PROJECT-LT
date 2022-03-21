package com.crs.lt.model;

/**
 * 
 * @author user215
 *  Model class for student
 */

public class Student {


	public String  studentId;

	public  String branch ;
	
	public String  batch;
	

	public String  isRegistered ;
	

	public String  isPaid; 
	


	public String isApproved;
	

	public  String isReportGenerated;

	
	public  String address;
	

	public  String gender;
	
	public  String name;
	
	
	public  String password;
	
	
	public  String role="STUDENT";
	

	public Student() {
		super();
	}

	public Student(String studentId, String branch, String batch, String isRegistered, String isPaid, String isApproved,
			String isReportGenerated) {
		super();
		this.studentId = studentId;
		this.branch = branch;
		this.batch = batch;
		this.isRegistered = isRegistered;
		this.isPaid = isPaid;
		this.isApproved = isApproved;
		this.isReportGenerated = isReportGenerated;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getIsRegistered() {
		return isRegistered;
	}

	public void setIsRegistered(String isRegistered) {
		this.isRegistered = isRegistered;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	public String getIsReportGenerated() {
		return isReportGenerated;
	}

	public void setIsReportGenerated(String isReportGenerated) {
		this.isReportGenerated = isReportGenerated;
	}
	
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", branch=" + branch + ", batch=" + batch + ", isRegistered="
				+ isRegistered + ", isPaid=" + isPaid + ", isApproved=" + isApproved + ", isReportGenerated="
				+ isReportGenerated + "]";
	}

	
	
	
	
}
