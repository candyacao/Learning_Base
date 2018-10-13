package com.candyacao.javademo.thread;

public class JoinThread extends Thread {
	public JoinThread(String name) {
		super(name);
	}
	//重写run()方法，定义线程执行体
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println(getName()+" "+ i);
		}
	}
	
	public static void main(String[] args) {
		new JoinThread("新线程").start();
		for(int i=0; i<100; i++) {
			if (i == 20) {
				JoinThread jt = new JoinThread("被join的线程");
				jt.start();
				// main方法调用了jt线程的join方法，main线程必须jt执行结束才能执行
				try {
					jt.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
}
