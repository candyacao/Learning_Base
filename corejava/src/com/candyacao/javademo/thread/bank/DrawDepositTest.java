package com.candyacao.javademo.thread.bank;

public class DrawDepositTest {
	public static void main(String[] args) {
		// 创建一个账户
		Account account = new Account("123455",0);
		new DrawThread("取钱者", account, 800).start();
		new DepositThread("存款者甲", account, 800).start();
		new DepositThread("存款者乙", account, 800).start();
		new DepositThread("存款者丙", account, 800).start();
	}
}
