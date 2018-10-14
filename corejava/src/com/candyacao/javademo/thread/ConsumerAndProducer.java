package com.candyacao.javademo.thread;
/**
 * 生产者和消费者 1. 出现数据紊乱 ： 原因是 生产和消费是不同步的， 解决方法：如果正在生产那就别消费，
 * 如果正在消费就别生产，给push和pull方法加锁 2. 数据重复 原因：出现了重复生产和重复消费的过程
 * 解决方法：判断数据有没有，进而让两条线程相互等待和相互唤醒
 * 
 * @author CLY
 *
 */
public class ConsumerAndProducer {
	public static void main(String[] args) {
		// 共享资源
		Food f = new Food();
		new Thread(new Producer(f)).start();
		new Thread(new Consumer(f)).start();

	}

}

/**
 * 消费者
 * @author CLY
 */
class Consumer implements Runnable {
	Food food;
	public Consumer(Food food) {
		this.food = food;
	}
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			food.pull();
		}
	}

}
/**
 * 生产者
 * 
 * @author CLY
 *
 */
class Producer implements Runnable {
	Food food;

	public Producer(Food food) {
		this.food = food;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			if (i % 2 == 0) {
				food.push("包子", "豆沙");
			} else {
				food.push("饺子", "鱼香肉丝");
			}
		}

	}

}

/**
 * 共享数据
 * 
 * @author CLY
 *
 */
class Food {
	String name; // 种类
	String type; // 馅料
	private boolean isEmpty = true;
	/**
	 * 生产食物的方式
	 */
	synchronized public void push(String name, String type) {
		try {
			while (isEmpty) {
				this.name = name;
			   Thread.sleep(10);
				this.type = type;
				isEmpty = false;
				this.notify();
			}
				this.wait();
			this.notifyAll();
			}
		catch (Exception e) {
			// TODO: handle exception
		}
		 
	}
	/**
	 * 消费食物的方法
	 */
	synchronized public void pull() {
		try {
			while (!isEmpty) {
				System.out.print(name + "	");
			Thread.sleep(10);
				System.out.println(type);
				isEmpty = true;
				this.notify();
			} 
				this.wait();
		        this.notifyAll();
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
		
	

}
