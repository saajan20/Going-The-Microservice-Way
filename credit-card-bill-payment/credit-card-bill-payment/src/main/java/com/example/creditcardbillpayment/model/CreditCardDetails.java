package com.example.creditcardbillpayment.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditCardDetails {
	
	
	@Id
	private String cardNo;
	private double cardBalance;
	private double cardLimit;
	private String cardExpirey;
	private String customerId;
	private String createdBy;
	private String createdOn;
	private String modifiedBy;
	private String modifiedOn;
	
	public CreditCardDetails() {
		
	}

	public CreditCardDetails(String customerId, String cardNo, double cardBalance, double cardLimit, String cardExpirey,
			String createdBy, String createdOn, String modifiedBy, String modifiedOn) {
		super();
		this.customerId = customerId;
		this.cardNo = cardNo;
		this.cardBalance = cardBalance;
		this.cardLimit = cardLimit;
		this.cardExpirey = cardExpirey;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
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

	public double getCardBalance() {
		return cardBalance;
	}

	public void setCardBalance(double cardBalance) {
		this.cardBalance = cardBalance;
	}

	public double getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(double cardLimit) {
		this.cardLimit = cardLimit;
	}

	public String getCardExpirey() {
		return cardExpirey;
	}

	public void setCardExpirey(String cardExpirey) {
		this.cardExpirey = cardExpirey;
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

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Override
	public String toString() {
		return "CreditCardDetails [customerId=" + customerId + ", cardNo=" + cardNo + ", cardBalance=" + cardBalance
				+ ", cardLimit=" + cardLimit + ", cardExpirey=" + cardExpirey + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn + "]";
	}

	
	
	

}
