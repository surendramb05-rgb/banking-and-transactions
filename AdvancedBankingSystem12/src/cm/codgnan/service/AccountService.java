package cm.codgnan.service;
import java.util.UUID;

import com.codegnan.dao.AccountDao;
import com.codegnan.dao.TranscationDao;
import com.codegnan.exception.AccountNotFound;
import com.codegnan.exception.InsuficinatBalance;

import model.Account;
import model.Transaction;
public class AccountService {
protected AccountDao accountDao;
protected TranscationDao transcationDao;
public AccountService(AccountDao accountDao, TranscationDao transcationDao) {
	super();
	this.accountDao = accountDao;
	this.transcationDao = transcationDao;
}
public void deposit(String accountnumber,double amount)throws AccountNotFound{
	Account acc=accountDao.findByAccountNumber(accountnumber);
	if(acc==null) throw new AccountNotFound("Account not found: "+accountnumber);
	acc.deposit(amount);
	transcationDao.save(new Transaction(UUID.randomUUID().toString(),accountnumber,"Deposit",amount, null));
}
public void withdraw(String accountnumber,double amount)throws AccountNotFound,InsuficinatBalance{
	Account acc=accountDao.findByAccountNumber(accountnumber);
	if(acc==null)throw new AccountNotFound("Account not found: "+accountnumber);
	acc.withdraw(amount);
	transcationDao.save(new Transaction(UUID.randomUUID().toString(),accountnumber,"Withdrawal",amount, null));
}
public double getBalance(String accountNumber)throws AccountNotFound{
	Account acc=accountDao.findByAccountNumber(accountNumber);
	if(acc==null)throw new AccountNotFound("account not found : "+accountNumber);
	return acc.getAbalance();
}
}
