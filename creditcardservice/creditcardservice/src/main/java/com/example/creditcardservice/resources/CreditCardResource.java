package com.example.creditcardservice.resources;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.creditcardservice.dao.CreditCardRepo;
import com.example.creditcardservice.models.CreditCardDetails;
import com.example.creditcardservice.models.LedgerDTO;
import com.example.creditcardservice.models.UpdateAmount;
import com.example.creditcardservice.service.CreditCardServices;

@RestController
//@RequestMapping("/customers")
public class CreditCardResource {
	
	@Autowired
	private CreditCardServices creditCardServices;
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	CreditCardRepo repo;
	
	@GetMapping(path="/customers/{customerId}/creditcard/{cardNo}", produces= {"application/json"})
	public CreditCardDetails getDetails(@PathVariable("customerId") String customerId,@PathVariable("cardNo")String cardNo){
    
    //Returning all the details of credit card having given cardNo and customerId.
	return creditCardServices.getCreditCardDetails(cardNo,customerId);
		
			
	}
	
	@PutMapping(path="/creditcard/{cardNo}")
	public CreditCardDetails updateAmount(@PathVariable("cardNo")String cardNo, @RequestBody UpdateAmount updateAmount){
	 
		CreditCardDetails creditCardDetails=creditCardServices.updateCreditCardAmount(cardNo,updateAmount);
		 System.out.println(creditCardDetails);
		
		 
		LedgerDTO ledgerDetails=new LedgerDTO(updateAmount.getTransactionId(),cardNo,updateAmount.getRequestType(),updateAmount.getAmount(),"credit-card","credit-card service",new Date().toString());
		
		ledgerDetails= restTemplate.postForObject("http://localhost:8084/save/transaction", ledgerDetails,LedgerDTO.class);
					
         return creditCardDetails;
		
	}
	
	
	
}
