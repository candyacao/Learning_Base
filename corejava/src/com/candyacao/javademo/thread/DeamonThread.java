package com.candyacao.javademo.thread;
/**
 * 测试后台线程的存活周期
 * @author candyacao
 * @created 2018年10月12日 下午7:52:36
 */
public class DeamonThread extends Thread {
	//定义后台线程的执行体，和普通线程的没有什么区别
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println(getName()+" "+i);
		}
	}
	
	public static void main(String[] args) {
		DeamonThread dt = new DeamonThread();
		//将此线程设置为后台线程
		dt.setDaemon(true);
		//启动后台线程
		dt.start();
		for(int i = 0; i<10; i++) {
			System.out.println(Thread.currentThread().getName()+" "+ i);
		}
		//程序执行到此处，main前台线程结束，后台线程也随之结束
	}
}
