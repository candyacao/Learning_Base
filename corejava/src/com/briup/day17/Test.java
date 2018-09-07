package com.briup.day17;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		int N=10000000;
		int n=10;
		int m=5;
		
		Shuffle shuffle=new Shuffle(N, n, m);
		shuffle.run();
	}
	
}

class Shuffle {

	int N;// 对算法的运算次数
	int n;// 格子数
	int m;// 雷数

	public Shuffle(int N, int n, int m) {
		this.N = N;
		this.n = n;
		this.m = m;
	}

	public void run() {

		int[] array = new int[n];

		int[] result=new int[n];
		
		for (int i = 0; i < N; i++) {
			reset(array);
			random(array);
			for(int j=0;j<n;j++) {
				result[j]+=array[j];
			}
		}
		
		for(int i=0;i<n;i++) {
			System.out.println("第"+i+"个位置上出现雷的概率:  "+((double)result[i]/N)*100+"%");
		}

	}

	public void reset(int[] array) {
		for (int i = 0; i < m; i++) {
			array[i] = 1;
		}
		for (int i = m; i < n; i++) {
			array[i] = 0;
		}
	}

	public void random(int[] array) {

		for (int i = 0; i < n; i++) {
 			int y = (int) (Math.random() * (n-i)+i);
			swap(array, i, y);
		}
		
		
//		for (int i = 0; i < m; i++) {
// 			int y = (int) (Math.random() * n);
//			swap(array, i, x);
//		}
		
//		for (int i = 0; i < n; i++) {
//			int x = (int) (Math.random() * n);
//			int y = (int) (Math.random() * n);
//			swap(array, x, y);
//		}

	}

	private void swap(int[] array, int x, int y) {
		// TODO Auto-generated method stub
		int a = array[x];
		array[x] = array[y];
		array[y] = a;
	}

}
