package com.candyacao.javademo.thread.bank;

public class Account {
	// 封装账户编号、账户余额的两个成员变量
	private String accountNum;
	private double balance;
	// 标识账户中是否已有存款的旗标
	private boolean flag = false;

	public Account() {
	}

	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public double getBalance() {
		return balance;
	}

	public synchronized void draw(double drawAmout) {

		try {
			// 如果flag为假，表示账户中还没有人存钱进去，取钱方法阻塞
			if (!flag) {
				wait();
			}else {
				// 执行取钱操作
				System.out.println(Thread.currentThread().getName()+"取钱："+ drawAmout);
				balance -= drawAmout;
				System.out.println("余额为：" + balance);
				// 将标识账户是否已有存款的旗标设为false
				flag = false;
				// 唤醒其他线程
				notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void deposit(double depositAmout) {
		
			try {
				// 如果flag为真，表明账户已有人存钱进去，存钱办法阻塞
				if (flag) {
					wait();
				}else {
					// 执行存款操作
					System.out.println(Thread.currentThread().getName()+" 存款："+depositAmout);
					balance += depositAmout;
					System.out.println("账户余额为："+balance);
					// 将表示账户是否以有存款的旗标设为true
					flag = true;
					// 唤醒其他线程
					notifyAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
}
