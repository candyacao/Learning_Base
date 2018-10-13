package com.candyacao.javademo.thread;

/**
 * 测试Synchronized关键字修饰方法
 * 取钱的线程，该线程类根据执行账户、取钱数量进行取钱操作， 
 * 取钱的逻辑是当余额不足时无法提取现金，当余额充足时吐出钞票 并显示余额
 * 
 * @author candyacao
 * @created 2018年10月13日 上午9:19:35
 */
public class DrawThreadSyn extends Thread {
	// 模拟用户账户
	private AccountSynchronized account;
	// 当前取钱线程所需要提取的钱数
	private double drawAmout;

	public DrawThreadSyn(String name, AccountSynchronized account, double drawAmout) {
		super(name);
		this.account = account;
		this.drawAmout = drawAmout;
	}

	// 当多线程修改同一个共享数据时，将涉及数据安全问题
	public void run() {
		/*
		 * 直接调用account对象的draw()方法来执行取钱操作，同步方法的同步监视器就是this
		 * this代表调用draw()方法的对象，即线程进入draw()方法之前，必须先对account对象加锁
		 * 这种做法符合：”加锁-----修改-----释放锁的逻辑“
		 */
		account.draw(drawAmout);

	}
}
