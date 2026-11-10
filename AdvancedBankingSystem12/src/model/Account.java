package model;

import com.codegnan.exception.AccountNotFound;
import com.codegnan.exception.InsuficinatBalance;

public abstract class Account {
private String acno;
private String owneruserid;
protected double abalance;
public Account(String acno, String owneruserid,double abalance) {
	this.acno = acno;
	this.owneruserid = owneruserid;
	this.abalance=abalance;
}
public double getAbalance() {
	return abalance;
}
public void setAcno(String acno) {
	this.acno = acno;
}
public void setOwneruserid(String owneruserid) {
	this.owneruserid = owneruserid;
}
public void setAbalance(double abalance) {
	this.abalance = abalance;
}
public String getAcno() {
	return acno;
}
public String getOwneruserid() {
	return owneruserid;
}
public synchronized void deposit(double amount) throws AccountNotFound {
	if(amount>0) {
		abalance+=amount;
	}else {
		throw new AccountNotFound("account is not found");
	}
}
public abstract void withdraw(double amount)throws InsuficinatBalance;


}
