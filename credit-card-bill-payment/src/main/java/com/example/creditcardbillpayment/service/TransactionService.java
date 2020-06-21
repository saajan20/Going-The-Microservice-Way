package com.example.creditcardbillpayment.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.creditcardbillpayment.model.AccountCommandModel;
import com.example.creditcardbillpayment.model.BillDTO;
import com.example.creditcardbillpayment.model.Transaction;
import com.example.creditcardbillpayment.repository.TransactionRepository;


@Service
public class TransactionService {

	@Autowired
	TransactionRepository repo;
	
	@Autowired
	private KafkaTemplate<String, AccountCommandModel> kafkaTemplate;
	
	public String detailsValidation(BillDTO billDTO)
	{
		int validationResponse=validateUserDetails(billDTO);
		if(validationResponse == -1)
			return "Invalid Account Number!";
		if(validationResponse == 0)
			return "Invalid Card Number!";
		if(validationResponse == 1)
			return "Invalid Customer ID!";
		if(validationResponse == -2)
			return "Invalid Amount!";
		
		return "valid";
		
	}
	
	public static int validateUserDetails(BillDTO billDTO)
	{
		
	if(billDTO.getAccountId().length()!=14 || billDTO.getAccountId().matches("\\d+")==false)
	return -1;
	if(billDTO.getCardNo().length()!=16 || billDTO.getCardNo().matches("\\d+")==false)
	return 0;
	if(billDTO.getCustomerId().length()!=9 || billDTO.getCustomerId().matches("[a-zA-Z0-9]*")==false)
	return 1;
	if(billDTO.getAmount()<=0)
	return -2;
	
	return 2;
	
   }
	
	public String generateTransactionId(String initialTransactionId)
	{
		 long size=repo.count();
		 long i=Long.parseLong(initialTransactionId.trim());
		 return String.valueOf(size+i);
		
   }
	
	public Transaction saveTransactionDetails(BillDTO details, String transactionId) {
		
		Date d=new Date();
		 Transaction transaction=new Transaction(transactionId,details.getAccountId(),details.getCustomerId(),details.getCardNo(),
				   details.getAmount(),"ABC",d.toString(),"null");
		 
		return repo.save(transaction);	
			
		
	}
	
public String getpaymentDone(BillDTO details, String transactionId) {
		
		
		return null;
		
	}

public void publishdata(AccountCommandModel data) {
	
	kafkaTemplate.send("account",data);
	
}
	
}
