package com.candyacao.javademo.thread.bank;
/**
 * 取款线程
 * @author candyacao
 * @created 2018年10月13日 上午11:03:33
 */
public class DrawThread extends Thread {
	// 模拟用户账户
	private Account account;
	// 当前取钱线程所希望取的钱数
	private double drawAmout;
	public DrawThread(String name, Account account, double drawAmout) {
		super(name);
		this.account = account;
		this.drawAmout = drawAmout;
	}
	public void run() {
		for(int i = 0; i< 100; i++) {
			account.draw(drawAmout);
		}
	}
	
}
