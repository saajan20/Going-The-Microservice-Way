package com.example.creditcardservice.models;

import java.util.Date;


public class ErrorResponse {
	
	
	private Date timeStampDate;
	private String message;
	private String details;
	
	
	
	public ErrorResponse(Date timeStampDate, String message, String details) {
	
		this.timeStampDate = timeStampDate;
		this.message = message;
		this.details = details;
	}
	public Date getTimeStampDate() {
		return timeStampDate;
	}
	public void setTimeStampDate(Date timeStampDate) {
		this.timeStampDate = timeStampDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	

}
