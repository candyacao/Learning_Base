package com.candyacao.javademo.thread;

/**
 * 测试调用run方法
 * @author candyacao
 * @created 2018年10月12日 下午12:08:00
 */
public class InvokeRun extends Thread {
	private int i;
	//重写run()方法，run()方法的方法体就是线程执行体
	public void run() {
		for( ; i<100; i++) {
			/*直接调用run()方法时，Thread的this.getName()返回的是
			 * 该对象的名字，而不是当前线程的名字,使用Thread.currentThread().getName()
			 * 总是获得当前对象的名字
			 */
			System.out.println(Thread.currentThread().getName()+" "+ i);
		}
	}
	
	public static void main(String[] args) {
		for(int i=0; i<100; i++) {
			//调用Thread的currentThread()方法获取当前线程
			System.out.println(Thread.currentThread().getName()+" "+ i);
			if (i== 20) {
				/*
				 * 直接调用线程对象的run()方法，系统会将线程对象当成普通对象
				 * 把run()方法当成普通方法，所以下面两行代码不会启动两个线程，
				 * 而是依次执行两个run()方法
				 */
//				new InvokeRun().run();
//				new InvokeRun().run();
				InvokeRun invokeRun = new InvokeRun();
				invokeRun.run();
				invokeRun.start();
				invokeRun.start();
			}
		}
	}
}
