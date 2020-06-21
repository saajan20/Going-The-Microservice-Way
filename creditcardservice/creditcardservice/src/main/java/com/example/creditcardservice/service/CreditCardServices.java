package com.example.creditcardservice.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.creditcardservice.dao.CreditCardRepo;
import com.example.creditcardservice.exception.CreditCardNotFoundException;
import com.example.creditcardservice.models.CreditCardDetails;
import com.example.creditcardservice.models.UpdateAmount;


@Service
public class CreditCardServices {
	
	
	public CreditCardServices() {
		
	}
	
	@Autowired
	CreditCardRepo repo;
	
	public CreditCardDetails getCreditCardDetails(String cardNo,String customerId)
	{
		//return repo.findByCardNoAndCustomerId(cardNo,customerId);
		CreditCardDetails creditCardDetails=repo.findByCardNoAndCustomerId(cardNo,customerId);
		if(creditCardDetails==null)
			throw new CreditCardNotFoundException(cardNo);
		
		return creditCardDetails;
	}

	public CreditCardDetails updateCreditCardAmount(String cardNo, UpdateAmount updateAmount) {
		
		CreditCardDetails creditCardDetails=repo.findById(cardNo).orElseThrow((null));
		Date d=new Date();
		CreditCardDetails newCreditCardDetails=new CreditCardDetails(creditCardDetails.getCustomerId(),
	    creditCardDetails.getCardNo(),creditCardDetails.getCardBalance()+updateAmount.getAmount(),
				creditCardDetails.getCardLimit(),creditCardDetails.getCardExpirey(),creditCardDetails.getCreatedBy(),
				creditCardDetails.getCreatedOn(),creditCardDetails.getModifiedBy(),d.toString());
		repo.delete(creditCardDetails);
		
		return repo.save(newCreditCardDetails);
		
	}	
	
	
}
	
	


