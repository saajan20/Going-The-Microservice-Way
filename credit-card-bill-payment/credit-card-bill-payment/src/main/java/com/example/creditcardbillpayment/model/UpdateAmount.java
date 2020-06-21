package com.example.creditcardbillpayment.model;

public class UpdateAmount {
	
	private String requestType;
	private double amount;
	private String transactionId;
	
	public UpdateAmount() {
		
	}

	public UpdateAmount(String requestType, double amount, String transactionId) {
		
		this.requestType = requestType;
		this.amount = amount;
		this.transactionId = transactionId;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	
	

}
