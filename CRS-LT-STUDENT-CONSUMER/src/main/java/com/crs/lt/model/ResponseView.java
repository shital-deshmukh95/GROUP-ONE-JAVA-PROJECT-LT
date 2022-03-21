package com.crs.lt.model;

public class ResponseView {
 public Object response;
 public  Integer statusCode;
 
 public ResponseView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseView(Object response, Integer statusCode) {
		super();
		this.response = response;
		this.statusCode = statusCode;
	}
 
 
public Object getResponse() {
	return response;
}
public void setResponse(Object response) {
	this.response = response;
}
public Integer getStatusCode() {
	return statusCode;
}
public void setStatusCode(Integer statusCode) {
	this.statusCode = statusCode;
}

@Override
public String toString() {
	return "ResponseView [response=" + response + ", statusCode=" + statusCode + "]";
}
 
 
	
}
