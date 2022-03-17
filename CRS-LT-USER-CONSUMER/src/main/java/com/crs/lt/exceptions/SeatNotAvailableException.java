package com.crs.lt.exceptions;

public class SeatNotAvailableException extends Exception {

	private String courseCode;

	public SeatNotAvailableException(String courseCode)
	{	
		this.courseCode = courseCode;
	}

	@Override
	public String getMessage() {
		return  "Seats are not available in : " + courseCode;
	}

}
