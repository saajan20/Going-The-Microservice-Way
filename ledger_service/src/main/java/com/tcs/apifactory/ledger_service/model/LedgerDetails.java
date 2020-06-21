package com.tcs.apifactory.ledger_service.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LedgerDetails {
	
	
	@EmbeddedId
	LedgerPK ledgerPK;
	private String transactionType;
	private double amount;
	private String accountType;
	private String createdBy;
	private String createdOn;
	
	
	public LedgerDetails() {
		
	}


	public LedgerDetails(LedgerPK ledgerPK, String transactionType, double amount, String accountType, String createdBy,
			String createdOn) {
		super();
		this.ledgerPK = ledgerPK;
		this.transactionType = transactionType;
		this.amount = amount;
		this.accountType = accountType;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
	}


	public LedgerPK getLedgerPK() {
		return ledgerPK;
	}


	public void setLedgerPK(LedgerPK ledgerPK) {
		this.ledgerPK = ledgerPK;
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
