package com.example.creditcardservice.exception;

public class CreditCardExpired extends RuntimeException{
	
	public CreditCardExpired(String cardNo)
	{
		super("Credit-Card has expired against: "+cardNo);
	}

}
