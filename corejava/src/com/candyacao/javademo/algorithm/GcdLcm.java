package com.candyacao.javademo.algorithm;

import java.util.Scanner;
/**
 * 求输入的两个数的最大公约数和最小公倍数
 * @author CLY
 *
 */
public class GcdLcm {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("请输入两个想要求最大公约数和最小公倍数的整数：");
		int num1= scanner.nextInt();
		int num2=scanner.nextInt();
		//最大公倍数初始化
		int gcd = 0;
		//最小公约数初始化
		int lcm = 0;
		if(num1<num2) {
			for(int i=num1;i>1;i--) {
				if((num1%i==0) && (num2%i==0)) {
					 gcd = i;
					int shang1=num1/i;
					int shang2=num2/i;
					lcm = i*shang1*shang2;
					break;
				}
			}
		}
		else {
			for(int i=num2;i>1;i--) {
				if((num1%i==0) && (num2%i==0)) {
					gcd = i;
					int shang1=num1/i;
					int shang2=num2/i;
					lcm = i*shang1*shang2;
					break;
				}
			}
		}
		System.out.println("这两个数的最大公约数为："+ gcd);
		System.out.println("这两个数的最小公倍数为："+ lcm);
	}

}
