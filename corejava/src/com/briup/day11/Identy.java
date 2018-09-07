package com.briup.day11;

import java.util.Scanner;
/**
 * 验证码的实现
 * @author CLY
 *
 */
public class Identy {
	public static final String date = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static void main(String[] args) {
		char[] array = new char[4];
		for(int i =0;i<4;i++) {
			int random = (int)(Math.random()*date.length());
			array[i] = date.charAt(random);
			
		}
		
		String passwd = new String(array);
		System.out.println("验证码是：" + passwd);
		System.out.println("请输入验证码");
		Scanner sc = new Scanner(System.in);
		String in = sc.next();
		if (passwd.equalsIgnoreCase(in)) {
			System.out.println("验证成功");
		}else {
			while(true) {
	
				in = sc.next();
				
			}
		}
		
	}

}
