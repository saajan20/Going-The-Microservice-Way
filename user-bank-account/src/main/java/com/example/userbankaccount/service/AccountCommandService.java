package com.example.userbankaccount.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.example.userbankaccount.exception.AccountNotFoundException;
import com.example.userbankaccount.model.AccountCommandModel;
import com.example.userbankaccount.model.LedgerDTO;
import com.example.userbankaccount.model.Transaction_History;
import com.example.userbankaccount.model.UpdateDto;
import com.example.userbankaccount.repository.AccountCommandRepository;
import com.example.userbankaccount.repository.Transaction_repository;

@Service
public class AccountCommandService {

	@Autowired
	AccountCommandRepository repo;
	
	@Autowired
	Transaction_repository t_repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public AccountCommandModel getusercheck (String customerid,String accountid)
	{
		AccountCommandModel mod = repo.findByAccountidAndCustomerid(accountid, customerid);
		if(mod==null)
			throw new AccountNotFoundException(accountid, customerid);
		return mod;
	}
	
	public Iterable<AccountCommandModel> getallUsers()
	{
		return repo.findAll();
	}
	
	public Optional<AccountCommandModel> getuser(String accountid)
	{
		return repo.findById(accountid);
	}
   
	public AccountCommandModel updatedetails(UpdateDto update, String accountid)
	{
		AccountCommandModel newone=repo.findById(accountid).orElseThrow(null);
		if((update.getRequest_type().compareTo("DEBIT"))==0)
		{
			System.out.println("hey there");
			newone.setAccountbalance(newone.getAccountbalance()-update.getAmount());
		    String dat=String.valueOf(new Date());
		    newone.setModifiedon(dat);
		    Transaction_History t=new Transaction_History(update.getTransaction_id(),dat);
		    repo.save(newone);
		    t_repo.save(t);
		    
		    LedgerDTO ledgerDetails=new LedgerDTO(update.getTransaction_id(),accountid,update.getRequest_type(),update.getAmount(),"SAVINGS","user-bank-account service",dat);
			ledgerDetails= restTemplate.postForObject("http://localhost:8084/save/transaction", ledgerDetails,LedgerDTO.class);
		}
		return newone;
	}
	
}
