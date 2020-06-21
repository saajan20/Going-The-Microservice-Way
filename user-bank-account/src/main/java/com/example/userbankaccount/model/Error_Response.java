package com.example.userbankaccount.model;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class Error_Response {


	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpstatus;
	private final ZonedDateTime timestamp;
	
	
	public Error_Response(String message, Throwable throwable, HttpStatus httpstatus, ZonedDateTime timestamp) {
		
		this.message = message;
		this.throwable = throwable;
		this.httpstatus = httpstatus;
		this.timestamp = timestamp;
	}


	public String getMessage() {
		return message;
	}


	public Throwable getThrowable() {
		return throwable;
	}


	public HttpStatus getHttpstatus() {
		return httpstatus;
	}


	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	
	
	
	
	
}
