package com.candyacao.javademo.thread;

/**
 * 取钱的线程，该线程类根据执行账户、取钱数量进行取钱操作， 取钱的逻辑是当余额不足时无法提取现金，当余额充足时吐出钞票 并显示余额
 * 
 * @author candyacao
 * @created 2018年10月13日 上午9:19:35
 */
public class DrawThread extends Thread {
	// 模拟用户账户
	private Account account;
	// 当前取钱线程所需要提取的钱数
	private double drawAmout;

	public DrawThread(String name, Account account, double drawAmout) {
		super(name);
		this.account = account;
		this.drawAmout = drawAmout;
	}

	// 当多线程修改同一个共享数据时，将涉及数据安全问题
	public void run() {
		// 同步代码块开始
		/*
		 * 使用account做同步监视器，任何线程在进入下列同步代码块之前，必须先获得对
		 * account账户的锁定-----其他线程无法获得锁，也无法修改他
		 * 这种做法符合：”加锁-----修改-----释放锁的逻辑“
		 */
		synchronized (account) {
			// 账户余额大于取钱数目
			if (account.getBalance() >= drawAmout) {
				// 吐出钞票
				System.out.println(getName() + "取钱成功！吐出钞票：" + drawAmout);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 修改余额
				account.setBalance(account.getBalance() - drawAmout);
				System.out.println("\t余额为：" + account.getBalance());
			} else {
				System.out.println(getName() + "取钱失败，余额不足");
			}
		}
		// 同步代码块结束，该线程释放同步锁

	}
}
