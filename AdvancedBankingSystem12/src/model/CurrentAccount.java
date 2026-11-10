package model;

import com.codegnan.exception.InsuficinatBalance;

public class CurrentAccount extends Account {
	private double overDraft;
	public CurrentAccount(String acno, String aname, double abalance,double overDraft) {
		super(acno, aname, abalance);
		this.overDraft=overDraft;
		
	}
	public double getOverDraft() {
		return overDraft;
	}
	public void chackBalance() {
		System.out.println(getAbalance()+overDraft);
	}
	@Override
	public synchronized void withdraw(double amount) throws InsuficinatBalance{
		if(getAbalance()+overDraft<0) {
			throw new InsuficinatBalance("insuficiant balance");
		}else {
			if(overDraft<0) {
			setAbalance(getAbalance()-amount);
			System.out.println(getAbalance());
			}else {
				overDraft-=amount;
			}
		}
	}
}
