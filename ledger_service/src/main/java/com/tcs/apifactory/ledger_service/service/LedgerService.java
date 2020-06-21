package com.tcs.apifactory.ledger_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.apifactory.ledger_service.dao.LedgerRepo;
import com.tcs.apifactory.ledger_service.model.LedgerDTO;
import com.tcs.apifactory.ledger_service.model.LedgerDetails;
import com.tcs.apifactory.ledger_service.model.LedgerPK;

@Service
public class LedgerService {
	
	@Autowired
	LedgerRepo repo;

	public void transactionDetails( LedgerDTO details) {
		
		LedgerDetails entry=new LedgerDetails(new LedgerPK(details.getTransactionId(), details.getAccountId()),details.getTransactionType(),details.getAmount(), details.getAccountType(), details.getCreatedBy(), details.getCreatedOn());
		repo.save(entry);
		
	}
	
	public List<LedgerDetails> all(){
		return repo.findAll();
	}

}
