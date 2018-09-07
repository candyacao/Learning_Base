package com.briup.day14;

public class MainCatcher {
	public void methodA(int money) throws SpecialException{
		if (--money<=0) {
			throw new SpecialException ("Out of money");
		}
		System.out.println("methodA");
	}
	
	public void methodB(int money) throws SpecialException{
		methodA(money);
		System.out.println("methodB");
	}
	
	public static void main(String[] args) {
		try {
			new MainCatcher().methodB(2);
			System.out.println("main");
		} catch (SpecialException e) {
			System.out.println("Wrong");
		}
	}
}

class SpecialException extends Exception{
	public SpecialException() {}
	public SpecialException(String msg) {super(msg);}
}