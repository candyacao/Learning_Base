package com.candyacao.javademo.thread;
/**
 * 测试可重入锁对象，将该账户设置成安全的
 * @author candyacao
 * @created 2018年10月13日 上午10:02:44
 */

import java.util.concurrent.locks.ReentrantLock;

public class AccountReentrantLock {
	//定义锁对象
	private final ReentrantLock lock = new ReentrantLock();
	//封装账号和账户余额两个成员变量
	private String accountNo;
	private double balance;
	//构造器
	public AccountReentrantLock() {}
	public AccountReentrantLock(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	//提供一个线程安全的draw()方法
	public void draw(double drawAmout) {
		//加锁
		lock.lock();
		try {
			if (balance >= drawAmout) {
				// 吐出钞票
				System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票：" + drawAmout);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 修改余额
				balance -= drawAmout;
				System.out.println("\t余额为：" + balance);
			} else {
				System.out.println(Thread.currentThread().getName() + "取钱失败，余额不足");
			}
		}finally {
			//修改完成释放锁
				lock.unlock();
			}
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
}
