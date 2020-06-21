package com.example.creditcardservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.creditcardservice.models.CreditCardDetails;

@Repository
public interface CreditCardRepo extends JpaRepository<CreditCardDetails, String> {
	
	
	
	 CreditCardDetails findByCardNoAndCustomerId(String cardNo,String customerId);
	 
	 @SuppressWarnings("unchecked")
	CreditCardDetails save(CreditCardDetails newCreditCardDetails);
	
}



