package com.example.userbankaccount.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.example.userbankaccount.exception.AccountNotFoundException;
import com.example.userbankaccount.model.AccountCommandModel;
import com.example.userbankaccount.model.AccountQueryModel;
import com.example.userbankaccount.repository.AccountQueryRepository;

@Service
public class AccountQueryService {
	
	@Autowired
	AccountQueryRepository repo;
	
	public AccountQueryModel getusercheck (String customerid,String accountid)
	{
		
		AccountQueryModel mod= repo.findByAccountidAndCustomerid(accountid, customerid);
		/*
		if(mod==null)
		{
			System.out.println("inside if condition");
			throw new AccountNotFoundException(accountid, customerid);
		}
		else
		{
			System.out.println("outside if condition" + mod);
		    return mod;
		}
		*/
		return mod;
	}
	
	public Iterable<AccountQueryModel> getallUsers()
	{
		return repo.findAll();
	}

	@KafkaListener(topics = "account")
	@KafkaHandler
	public void save(@Payload AccountCommandModel data) {
		repo.save(new AccountQueryModel(data.getAccountid(), data.getAccounttype(), data.getAccountbalance(), data.getCustomerid(), data.getCreatedby(),data.getCreatedon(),"kafka", new Date().toString()));
	}

}
