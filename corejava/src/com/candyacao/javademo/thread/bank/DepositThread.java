package com.candyacao.javademo.thread.bank;

public class DepositThread extends Thread {
	// 模拟用户账户
	private Account account;
	// 当前存款线程所希望存的款数
	private double depositAmout;
	public DepositThread(String name, Account account, double depositAmout) {
		super(name);
		this.account = account;
		this.depositAmout = depositAmout;
	}
	public void run() {
		for(int i=0; i<100; i++) {
			account.deposit(depositAmout);
		}
	}
}
