package com.candyacao.javademo.array;

public class RandomSort {
	
	public static void main(String[] args) {
		int[] a= new int[10];
		
		for (int i=0;i<a.length;i++) {
			a[i] = i+1;
			System.out.print(a[i] + "  ");
		}
		System.out.println( "\n"+ "初始化后的数组如下：");
		for (int j:a) {
			System.out.print(j+" ");
		}
		System.out.println("\n" + "打乱顺序后的数组如下：");
		for (int i=a.length-1;i>0;i--) {
			int k =(int)(Math.random() * 10+1);
			int temp = a[i];
			a[i] = a[k];
			a[k] = temp;
			
		}
		for (int j:a) {
			System.out.print(j+" ");
		}
	}

}
