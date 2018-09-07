package com.briup.day18;

public class ThreadDemo1 {
	public static void main(String[] args) {
		Thread t = new Thread(){
				public void run() {
					pong();
				}
		};
		t.start();
		System.out.println("ping");	
	}
	
	static void pong() {
		System.out.println("pong");
	}

}
