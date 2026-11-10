package cm.codgnan.service;

import java.util.List;

import com.codegnan.dao.TranscationDao;

import model.Transaction;

public class ExportService {
private TranscationDao transactionDao;


public ExportService(TranscationDao transactionDao) {
	this.transactionDao=transactionDao;
}
public String exportStatementasCSV(String accountnumber) {
	List<Transaction> txs=transactionDao.findByAccountNumber(accountnumber);
	StringBuilder csv=new StringBuilder("TransactionID,Account,type,amount,Timestamp\n");
	for(Transaction tx:txs) {
	 csv.append(tx.getTransactionid()).append(",")
		.append(tx.getAccountnumber()).append(",")
		.append(tx.getType()).append(",")
		.append(tx.getAmount()).append(",")
		.append(tx.getTimestemp()).append("\n");
	}
	return csv.toString();
}
public TranscationDao getTransactionDao() {
	return transactionDao;
}

}