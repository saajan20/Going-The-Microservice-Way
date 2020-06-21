package com.tcs.apifactory.ledger_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.apifactory.ledger_service.model.LedgerDetails;
import com.tcs.apifactory.ledger_service.model.LedgerPK;

public interface LedgerRepo extends JpaRepository<LedgerDetails,LedgerPK> {


}
