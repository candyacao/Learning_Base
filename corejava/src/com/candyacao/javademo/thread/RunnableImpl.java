package com.candyacao.javademo.thread;
/**
 * 通过实现Runnable接口实现多线程
 * @author candyacao
 * @created 2018年10月12日 上午11:13:30
 */
public class RunnableImpl implements Runnable{
    //run()方法同样是线程执行体
	private int i;
	@Override
	 public void run(){
       for(; i < 100; i++){
           /*
           * 当线程类实现Runnable接口时，如果想要获得当前线程，只能用Thread.currentThread()方法
           */
           System.out.println(Thread.currentThread().getName() + " " + i);
       }
   }
    public static void main(String[] args){
        for(int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i == 20){
            	RunnableImpl st = new RunnableImpl();
                // 通过new Thread(target, name)方法创建新线程
                new Thread(st, "新线程1").start();
                new Thread(st, "新线程2").start();
            }
        }
    }

	

}
