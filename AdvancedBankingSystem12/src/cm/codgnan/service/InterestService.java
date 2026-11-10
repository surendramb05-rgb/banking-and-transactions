package cm.codgnan.service;

import com.codegnan.dao.AccountDao;

import model.Account;
import model.SavingsAccount;

public class InterestService {
private AccountDao accountDao;

public InterestService(AccountDao accountDao) {
	super();
	this.accountDao = accountDao;
}
public void applyAnnualInterest() {
	for(Account acc: accountDao.findall().values()) {
	if(acc instanceof SavingsAccount savings) {
		double interest=savings.getAbalance()*(savings.getInterestRate()/100.00);
		savings.deposit(interest);
		System.out.println(interest);
	}
	}
}

}
