package model;

import com.codegnan.exception.InsuficinatBalance;

public class SavingsAccount extends Account{
	private double minbalance=500.00;
	private double interestrate;
	public SavingsAccount(String acno, String owneruserid, double abalance, double interestrate) {
		super(acno, owneruserid, abalance);
		this.interestrate = interestrate;
	}
	public double getInterestRate() {
		return interestrate;
	}
	@Override
	public synchronized void withdraw(double amount) throws InsuficinatBalance {
		if(getAbalance()-amount<minbalance) {
			throw new InsuficinatBalance("insuficiant balance");
		}else {
			setAbalance(getAbalance()-amount);
			System.out.println(getAbalance());
		}
	}
	public void chackBalance() {
		System.out.println(getAbalance());
	}
	public void deposit(double amount) {
		setAbalance(getAbalance()+amount);
	}
}
