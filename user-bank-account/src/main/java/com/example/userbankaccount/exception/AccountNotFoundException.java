package com.example.userbankaccount.exception;

@SuppressWarnings("serial")
public class AccountNotFoundException extends RuntimeException{

	public AccountNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AccountNotFoundException(String account_no,String cutomer_id) {
		super("Account doesn't exist for Customer: " + cutomer_id + " against Account No: "+account_no);  
		// TODO Auto-generated constructor stub
	}

	

}