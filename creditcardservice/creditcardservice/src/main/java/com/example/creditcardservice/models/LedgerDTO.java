package com.example.creditcardservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;


public class LedgerDTO {
	
	
	private String transactionId;
	private String accountId;
	private String transactionType;
	private double amount;
	private String accountType;
	private String createdBy;
	private String createdOn;
	
	
	
	
	
	
	
	public LedgerDTO() {
		
	}



	public LedgerDTO(String transactionId, String accountId, String transactionType, double amount, String accountType,
			String createdBy, String createdOn) {
	
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.accountType = accountType;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
	}
	
	
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

}
