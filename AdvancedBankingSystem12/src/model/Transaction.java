package model;

import java.time.LocalDateTime;

public class Transaction {
private String transactionid;
private String accountnumber;
private String type;
private double amount;
private LocalDateTime timestemp;
public Transaction(String transactionid, String accountnumber, String type, double amount, LocalDateTime timestemp) {
	this.transactionid = transactionid;
	this.accountnumber = accountnumber;
	this.type = type;
	this.amount = amount;
	this.timestemp = timestemp;
}
public String getTransactionid() {
	return transactionid;
}
public String getAccountnumber() {
	return accountnumber;
}
public String getType() {
	return type;
}
public double getAmount() {
	return amount;
}
public LocalDateTime getTimestemp() {
	return timestemp;
}
@Override
public String toString() {
	return "[transactionid=" + transactionid + ", accountnumber=" + accountnumber + ", type=" + type
			+ ", amount=" + amount + ", timestemp=" + timestemp + "]";
}

}
