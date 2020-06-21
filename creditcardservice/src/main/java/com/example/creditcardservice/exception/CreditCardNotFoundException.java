package com.example.creditcardservice.exception;

public class CreditCardNotFoundException extends RuntimeException {
	
	public CreditCardNotFoundException(String cardNo)
	{
		super("Credit-Card  does not exist against: "+cardNo);
	}

}
