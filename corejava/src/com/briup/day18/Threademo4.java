package com.briup.day18;

public class Threademo4 {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				
			}
		}.start();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}).start();
		
		
		
		new Thread(()-> {
			//
		} ).start();
		}
	}


