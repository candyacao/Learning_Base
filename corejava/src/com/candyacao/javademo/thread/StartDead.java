package com.candyacao.javademo.thread;
/**
 * 测试已经处于死亡状态的线程能否通过调用start()方法重新启动线程
 * @author candyacao
 * @created 2018年10月12日 下午4:23:05
 */
public class StartDead extends Thread {
	private int i;
	// 重写run()方法，run()方法的方法体就是线程的执行体
	public void run() {
		for( ; i<100; i++) {
			System.out.println(getName()+" "+i);
		}
	}
	public static void main(String[] args) {
		StartDead sDead = new StartDead();
		for(int i = 0; i<300;i++) {
			//调用Thread的currentThread()获取当前线程
			System.out.println(Thread.currentThread().getName()+" "+ i);
			if (i == 20) {
				//启动线程
				sDead.start();
				//判断启动后线程的isAlive()的值，输出true
				System.out.println(sDead.isAlive());
			}
			/*
			 * 当线程处于新建、死亡两种状态时，isAlive()方法返回false
			 * 当i大于20时，该线程肯定已经启动过了，如果sDead.isAlive()为假时
			 * 那就是死亡状态了
			 */
			if (i>20 && !sDead.isAlive()) {
				// 试图再次启动该线程
				sDead.start();
			}
		}
	}
}
