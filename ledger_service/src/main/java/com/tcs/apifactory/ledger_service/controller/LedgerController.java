package com.tcs.apifactory.ledger_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.apifactory.ledger_service.model.LedgerDTO;
import com.tcs.apifactory.ledger_service.model.LedgerDetails;
import com.tcs.apifactory.ledger_service.service.LedgerService;

@RestController
public class LedgerController {
	
	@Autowired
	LedgerService ledgerService;
	
	@PostMapping(path="/save/transaction")
	public void saveTransactionDetails(  @RequestBody LedgerDTO Details)
	{
		 ledgerService.transactionDetails(Details);
	}
	
	@GetMapping("/ledger")
	public List<LedgerDetails> getall()
	{
		return ledgerService.all();
	}

}
