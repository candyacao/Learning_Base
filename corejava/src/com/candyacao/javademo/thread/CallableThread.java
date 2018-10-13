package com.candyacao.javademo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 使用Callable和Future创建有返回值的线程
 * 
 * @author candyacao
 * @created 2018年10月12日 上午11:11:04
 */
public class CallableThread {
	public static void main(String[] args) {
		// 创建Callable对象
		CallableThread ct = new CallableThread();
		// 先使用Lambda表达式创建Callable<Integer>对象
		// 使用FutrueTask来包装Callable对象
		FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>) () -> {
			int i = 0;
			for (; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + " 的循环变量i的值：" + i);
			}
			// call()方法有返回值
			return i;
		});
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " 的循环变量i的值：" + i);
			if (i == 20) {
				// 实质还是以Callable对象来创建并启动线程的
				new Thread(task, "有返回值的线程").start();
			}
		}

		try {
			// 获取线程的返回值
			System.out.println("子线程的返回值：" + task.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
