package cm.codgnan.service;

import java.util.UUID;

import com.codegnan.dao.AccountDao;
import com.codegnan.dao.TranscationDao;
import com.codegnan.exception.AccountNotFound;
import com.codegnan.exception.InsuficinatBalance;

import model.Account;
import model.Transaction;

public class ConcurentTransctionService extends AccountService {

	public ConcurentTransctionService(AccountDao accountDao, TranscationDao transcationDao) {
		super(accountDao, transcationDao);
	}
	public void transfer(String fromaccnum,String toaccnum,double amount) throws AccountNotFound, InsuficinatBalance {
		Account fromacc=accountDao.findByAccountNumber(fromaccnum);
		Account toacc=accountDao.findByAccountNumber(toaccnum);
		if(fromacc==null||toacc==null) {
			throw new AccountNotFound("one or both accounts were not found");
		}
		Account firstLock=fromacc.getAcno().compareTo(toacc.getAcno())<0? fromacc:toacc;
		Account secondLock=fromacc.getAcno().compareTo(toacc.getAcno())<0?toacc:fromacc;
		synchronized (firstLock) {
			synchronized(secondLock) {
				fromacc.withdraw(amount);
				toacc.deposit(amount);
				transcationDao.save(new Transaction(UUID.randomUUID().toString(),fromaccnum,"Transfer_out",amount, null));
				transcationDao.save(new Transaction(UUID.randomUUID().toString(),toaccnum,"Transfer_in",amount, null));
			}
		}
	}

}
