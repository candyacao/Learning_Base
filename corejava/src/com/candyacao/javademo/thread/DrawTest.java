package com.candyacao.javademo.thread;

public class DrawTest {
	public static void main(String[] args) {
		// 创建一个账户
		AccountSynchronized account = new AccountSynchronized("1234567",1000);
		// 模拟两个线程对同一个账户取钱
		new DrawThreadSyn("甲", account, 800).start();
		new DrawThreadSyn("乙", account, 800).start();
		
		// 创建一个账户
				Account account1 = new Account("1234567",1000);
				// 模拟两个线程对同一个账户取钱
				new DrawThread("甲", account1, 800).start();
				new DrawThread("乙", account1, 800).start();
	}
}
