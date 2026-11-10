package com.codegnan.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Transaction;

public class TranscationDao {
private List<Transaction> transcationHistory=Collections.synchronizedList(new ArrayList<>());
public void save(Transaction tx) {
	transcationHistory.add(tx);
}
public List<Transaction> findByAccountNumber(String accnum){
	List<Transaction> result=new ArrayList<>();
	synchronized(transcationHistory) {
		for(Transaction tx:transcationHistory) {
			if(tx.getAccountnumber().equals(accnum)) {
				result.add(tx);
			}
		}
	}
	return result;
}
}
