package com.tcs.apifactory.ledger_service.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class LedgerPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String transactionId;
	private String accountId;
	
	
	
	public LedgerPK() {
	
	}
	public LedgerPK(String transactionId, String accountId) {
		
		this.transactionId = transactionId;
		this.accountId = accountId;
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
	
}
