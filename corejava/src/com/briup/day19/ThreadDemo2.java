package com.briup.day19;

public class ThreadDemo2 {

	public static void main(String[] args) {

		Food1111 food = new Food1111();
		new Thread(new Producer1(food)).start();
		new Thread(new Consunmer1(food)).start();

	}

}

class Producer1 implements Runnable {

	private Food1111 food;

	public Producer1(Food1111 food) {
		// TODO Auto-generated constructor stub
		this.food = food;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 50; i++) {
			if (i % 2 == 0) {

				food.push("饺子", "素");

			} else {
				food.push("包子", "肉");
			}
		}
	}
}

class Consunmer1 implements Runnable {

	private Food1111 food;

	public Consunmer1(Food1111 food) {
		// TODO Auto-generated constructor stub
		this.food = food;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			food.pull();
		}
	}

}

class Food1111 {

	private String name;
	private String type;
	private boolean isEmpty = true;// 表示共享资源对象是否为空，如果为空则生产，如果不为空在消费

	/**
	 * 生产者向共享资源对象中存放数据
	 * 
	 * @param name
	 * @param type
	 */
	synchronized public void push(String name, String type) {
		try {
			while (!isEmpty) {
				this.wait();// 表示当前线程释放同步锁，进入等待池中，只能被其他线程所唤醒
			}
			// -------------------生产开始---------------------
			this.name = name;
			Thread.sleep(10);
			this.type = type;
			// -------------------生产结束---------------------8
			isEmpty = false;// 设置共享资源中数据不为空
			this.notify();// 唤醒一个消费者
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	synchronized public void pull() {
		try {
			while (isEmpty) {
				this.wait();
			}
			// ------------------消费开始------------------------
			System.out.print(name + "	");
			Thread.sleep(10);
			System.out.println(type);
			// ---------------------消费结束-----------------
			isEmpty = true;
			this.notify();// 唤醒一个生产者
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
