package com.example.userbankaccount.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//import com.example.userbankaccount.model.AccountCommandModel;
import com.example.userbankaccount.model.AccountQueryModel;
//import com.example.userbankaccount.service.AccountCommandService;
import com.example.userbankaccount.service.AccountQueryService;

@RestController
public class AccountQueryController {

	@Autowired
	AccountQueryService serve;
	
	@GetMapping("/customers/{customerid}/accounts_details/{accountid}")
	public ResponseEntity<AccountQueryModel> getuser (@PathVariable String customerid,@PathVariable String accountid) {
	
		AccountQueryModel bod=serve.getusercheck(customerid, accountid);
		if(bod==null)
		{
			return new ResponseEntity<AccountQueryModel>(bod,HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<AccountQueryModel>(bod,HttpStatus.OK);
	}
}
