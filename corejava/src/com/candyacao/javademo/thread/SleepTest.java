package com.candyacao.javademo.thread;

import java.util.Date;

public class SleepTest {
	public static void main(String[] args) {
		for(int i = 0; i<10; i++) {
			System.out.println("当前时间"+new Date());
			try {
				// 调用sleep()方法让当前线程暂停1秒
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
