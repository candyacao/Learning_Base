package com.briup.day18;

public class ThreadDemo3 {
	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		myThread.start();
		
		for(int i=0;i<50;i++) {
			Thread.sleep(200);
			System.out.println("玩游戏");
		}
	}

}

/**
 * 1. 定义了类A继承Thread类：（线程类）
 * 2. 在类A中重写Thread的run方法
 * 3. 在run中写需要线程执行的代码
 * 4. 在main方法中
 * @author CLY
 *
 */
class MyThread extends Thread{
	
	public void run() {
		for(int i= 0;i<50;i++) {
			try {
				sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("听音乐");
		}
	}
}
