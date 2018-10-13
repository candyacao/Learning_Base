package com.candyacao.javademo.thread;

/**
 * 通过继承Thread类来创建线程类
 * 
 * @author candyacao
 * @created 2018年10月12日 上午11:12:41
 */
public class ExtendThread extends Thread {
	private int i;

	// 重写run()方法，run()方法的方法体就是线程执行体
	public void run() {
		for (; i < 100; i++) {
			// 当线程类继承Thread类时，直接使用this即可获得当前线程
			// Thread对象的getName()返回当前线程的名字
			// 因此可以直接调用getName()方法返回当前线程的名字
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			// 调用Thread的currentThread()方法获取当前线程
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				// 创建并启动第一个线程
				new ExtendThread().start();
				// 创建并启动第二个线程
				new ExtendThread().start();
			}
		}
	}
}