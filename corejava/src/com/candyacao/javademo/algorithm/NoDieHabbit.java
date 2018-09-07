package com.candyacao.javademo.algorithm;

import java.util.Scanner;

public class NoDieHabbit{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入您想知道的第几个月的兔子的总对数：");
		int n = in.nextInt();
		System.out.println("第"+n + "个月的兔子的总对数为"+ fun(n));
		System.out.println("第"+n + "个月的兔子的总对数为"+ fun1(n));
		
	}
	/**
	 * 方法一：递归思想
	 * @param n
	 * @return
	 */
	public static int fun(int n) {
		if (n==1||n==2) {
			return 1;
		}else {
			return fun(n-1)+fun( n -2);
		}
	}
	
	/**
	 * 方法二：迭代思想
	 */
	
	public static int fun1(int n) {
		if(n<=1) {
			return 1;
		}
			int[] array = new int[n];
			array[0] = 1;
			array[1] = 1;
			for(int i=2;i<array.length;i++) {
				array[i] = array[i-1]+array[i-2];
			}
			return array[n-1];		
		}
	
}
