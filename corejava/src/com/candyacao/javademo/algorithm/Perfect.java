package com.candyacao.javademo.algorithm;

import java.util.Scanner;
/**
 * 若一个自然数，恰好与除去它本身以外的一切因数的和相等，这种数叫做完全数。
 * @author CLY
 *
 */
public class Perfect {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入想要求的哪个数之内的完全数：");
		int n = scanner.nextInt();
		
		for (int i = 2; i <n; i++) {
			int sum = 0;
			//针对每个i，求其除自身之外的所有因子的和
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					sum = sum + j;
				}
			}
			//判断是否是完全数
			if (i == sum) {
				System.out.println(i);
			}
		} 
	}

}
