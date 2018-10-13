package com.candyacao.javademo.thread;
/**
 * 账户类 
 * @author candyacao
 * @created 2018年10月13日 上午9:18:29
 */
public class Account {
	//封装账户编号和账户余额两个成员变量
	private String accountNum;
	private double balance;
	//构造器
	public Account() {}
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}
	//get和set方法
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public int hashCode() {
		return accountNum.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj != null && accountNum.getClass() == obj.getClass()) {
			Account other = (Account) obj;
			return other.getAccountNum().equals(accountNum);
		}
		return false;
	}
		
	
	
	

}
