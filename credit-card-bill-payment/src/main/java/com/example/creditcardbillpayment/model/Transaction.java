package com.example.creditcardbillpayment.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	
	@Id
	private String transactionId;
	private String accountNo;
	private String customerId;
	private String cardNo;
	private double amount;
	private String createdBy;
	private String createdOn;
	private String transactionStatus;
	
	public Transaction() {
	}

	public Transaction(String transactionId, String accountNo, String customerId, String cardNo, double amount,
			String createdBy, String createdOn, String transactionStatus) {
		super();
		this.transactionId = transactionId;
		this.accountNo = accountNo;
		this.customerId = customerId;
		this.cardNo = cardNo;
		this.amount = amount;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.transactionStatus = transactionStatus;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", accountNo=" + accountNo + ", customerId=" + customerId
				+ ", cardNo=" + cardNo + ", amount=" + amount + ", createdBy=" + createdBy + ", createdOn=" + createdOn
				+ ", transactionStatus=" + transactionStatus + "]";
	}
	
	
	
	

}
