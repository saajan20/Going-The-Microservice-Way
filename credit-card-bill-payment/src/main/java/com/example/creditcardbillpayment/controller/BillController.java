package com.example.creditcardbillpayment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.creditcardbillpayment.model.AccountCommandModel;
import com.example.creditcardbillpayment.model.BillDTO;
import com.example.creditcardbillpayment.model.CreditCardDetails;
import com.example.creditcardbillpayment.model.Transaction;
import com.example.creditcardbillpayment.model.UpdateAmount;
import com.example.creditcardbillpayment.model.UpdateDto;
import com.example.creditcardbillpayment.repository.TransactionRepository;
import com.example.creditcardbillpayment.service.TransactionService;

@RestController
public class BillController {
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	TransactionRepository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	 
	@Value(value = "${initial.transactionid}")
    String initialTransactionId;
	
	@PostMapping("/bank-account/online-credit-card-payment")
	public String initiateBillPayment(@RequestBody BillDTO billDTO) {
		
		 
		String isValid=transactionService.detailsValidation(billDTO);
		
		if(isValid.equals("valid") == false)
			return isValid;
		
		String transactionId=transactionService.generateTransactionId(initialTransactionId);
		
		Transaction savedTransaction=transactionService.saveTransactionDetails(billDTO,transactionId);
		
		//for verifying the Account Number and Customer Id, this call is to user-bank-account for fetching complete details.
		String URL="http://localhost:8083/customers/"+billDTO.getCustomerId()+"/accounts/"+billDTO.getAccountId();	
		System.out.println(URL);
		AccountCommandModel accountCommandModel= restTemplate.getForObject(URL,AccountCommandModel.class);
		System.out.println(accountCommandModel);
	
		//for verifying the Card Number and Customer Id, this call is to credit-card-service for fetching complete details
		URL="http://localhost:8082/customers/"+billDTO.getCustomerId()+"/creditcard/"+billDTO.getCardNo();
		System.out.println(URL);
		CreditCardDetails creditCardDetials= restTemplate.getForObject(URL,CreditCardDetails.class);
		System.out.println(creditCardDetials);
		
		
		//now we are calling user-bank-account again for debiting the amount
		UpdateDto updateAccountBalance=new UpdateDto("DEBIT",billDTO.getAmount(),transactionId);
		URL="http://localhost:8083/accounts/"+billDTO.getAccountId();
		System.out.println(URL);
		restTemplate.put(URL,updateAccountBalance);
		
		
		//updation of read model through apache kafka
		 URL="http://localhost:8083/customers/"+billDTO.getCustomerId()+"/accounts/"+billDTO.getAccountId();	
		 AccountCommandModel send_data = restTemplate.getForObject(URL,AccountCommandModel.class);
		 transactionService.publishdata(send_data);
		
		
		//now we are calling credit-card-service again for crediting the amount.
		UpdateAmount updateAmount=new UpdateAmount("Credit",billDTO.getAmount(),transactionId);
		URL= "http://localhost:8082/creditcard/"+billDTO.getCardNo();
		System.out.println(URL);
		restTemplate.put(URL,updateAmount);
		
		//return updatedCreditCardDetials.toString();*/
		
		savedTransaction.setTransactionStatus("Successful");
			
		return "Success!";
	}
	
	
	@GetMapping("/")
	public List<Transaction> getall()
	{
		return repo.findAll();
	}

}
