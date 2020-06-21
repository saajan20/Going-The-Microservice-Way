package com.example.userbankaccount.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userbankaccount.model.AccountCommandModel;
import com.example.userbankaccount.model.Transaction_History;
import com.example.userbankaccount.model.UpdateDto;
import com.example.userbankaccount.repository.Transaction_repository;
import com.example.userbankaccount.service.AccountCommandService;

@RestController
public class AccountCommandController {

	@Autowired
	AccountCommandService serve;
	
	@Autowired
	Transaction_repository t_repo;
	
	@GetMapping("/customers/{customerid}/accounts/{accountid}")
	public AccountCommandModel getuser (@PathVariable String customerid,@PathVariable String accountid) {
	
		return serve.getusercheck(customerid, accountid);
	}
	 
	@PutMapping("/accounts/{accountid}")
	public AccountCommandModel Updateuser(@RequestBody UpdateDto update,@PathVariable String accountid)
	{
		System.out.println(update.getAmount()+" "+update.getRequest_type()+" "+update.getTransaction_id());
		return serve.updatedetails(update, accountid);          		
	}
	
	@GetMapping("/")
	public List<Transaction_History> gethistory()
	{
		return t_repo.findAll();
	}
	
}
