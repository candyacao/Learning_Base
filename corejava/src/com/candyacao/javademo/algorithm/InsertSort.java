package com.candyacao.javademo.algorithm;

public class InsertSort {
	
	public static void main(String[] args) {
		int[] array = {3,5,20,13,24,6,48,28};
		int[] array1 = new int[array.length];
		//为了数据的完整性，所以将原始数组备份后再进行排序
		System.arraycopy(array, 0, array1, 0,array.length);
		int[] arr = arraySort(array1); 
		
		//增强for循环来打印数组
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	
	/**
	 * 插入排序
	 * @param arr
	 * @return
	 */
	public static int[] arraySort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			
		}
		return arr;
	}

}
