package com.briup.day18;

public class ThreadDemo2 {
	public static void main(String[] args) throws InterruptedException {
		//PlayGame playGame = new PlayGame();
		Thread t = new Thread(new PlayGame());
		t.start();
		
		for(int i=0;i<50;i++) {
			Thread.sleep(200);
			System.out.println("ÌýÒôÀÖ");
		}
			
	}

}

class PlayGame implements Runnable{

	@Override
	public void run() {
		for(int i = 0;i<50;i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("´òÓÎÏ·");
		}
			
	}
	
}