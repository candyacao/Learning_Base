package com.candyacao.javademo.thread;
/**
 * 测试Synchronized关键字修饰方法
 * @author candyacao
 * @created 2018年10月13日 上午10:04:07
 */
public class AccountSynchronized {
	// 封装账户编号和账户余额两个成员变量
	private String accountNum;
	private double balance;

	// 构造器
	public AccountSynchronized() {
	}

	public AccountSynchronized(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}

	// get和set方法
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
		// 账户余额大于取钱数目
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
