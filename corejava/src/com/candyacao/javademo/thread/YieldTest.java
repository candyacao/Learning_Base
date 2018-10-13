package com.candyacao.javademo.thread;

public class YieldTest extends Thread {
	public YieldTest(String name) {
		super(name);
	}
	// 定义run()方法作为线程执行体
	public void run() {
		for(int i=0; i<50; i++) {
			System.out.println(getName()+" "+ i);
			// 当i=20时，使用yield()方法让当前线程让步
			if (i==20) {
				Thread.yield();
			}
		}
	}
	
	public static void main(String[] args) {
		//启动两个并发线程
		YieldTest yt1 = new YieldTest("高级");
		//将yt1线程设置为最高优先级
		yt1.setPriority(MAX_PRIORITY);
		yt1.start();
		YieldTest yt2 = new YieldTest("低级");
		//将yt2线程设置为最低优先级
		 yt2.setPriority(MIN_PRIORITY);
		yt2.start();
	}
}
