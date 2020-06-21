package com.example.creditcardbillpayment.model;

public class BillDTO {
	
	private String customerId;
	private String accountId;
	private double amount;
	private String cardNo;
	
	
	public BillDTO() {
		
	}


	public BillDTO(String customerId, String accountId, double amount, String cardNo) {
		super();
		this.customerId = customerId;
		this.accountId = accountId;
		this.amount = amount;
		this.cardNo = cardNo;
	}




	public String getCustomerId() {
		return customerId;
	}




	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}




	public String getAccountId() {
		return accountId;
	}




	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}




	public double getAmount() {
		return amount;
	}




	public void setAmount(double amount) {
		this.amount = amount;
	}




	public String getCardNo() {
		return cardNo;
	}




	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}




	@Override
	public String toString() {
		return "BillDTO [customerId=" + customerId + ", accountId=" + accountId + ", amount=" + amount + ", cardNo="
				+ cardNo + "]";
	}

    


	


}
