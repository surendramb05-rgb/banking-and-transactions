package com.codegnan.dao;
import model.Account;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AccountDao {
private Map<String,Account> accountStorage=new ConcurrentHashMap<>();
public void save(Account acnumber) {
	accountStorage.put(acnumber.getAcno(), acnumber);
}
public Account findByAccountNumber(String accountnumber) {
	return accountStorage.get(accountnumber);
}
public Map<String,Account> findall(){
	return accountStorage;
}
}
