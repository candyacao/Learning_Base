package com.candyacao.javademo.algorithm;

import java.util.Arrays;

public class SelectSort {
	
	public static void main(String[] args) {
		int[] array = {314,298,508,123,486,145};
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
	 * 选择排序
	 * @param arr：需要进行排序的数组
	 * @return：排好序的数组
	 */
	public static int[] arraySort(int[] arr) {
	
		boolean flag = false;
		int minIndex,temp;
		for(int i=0;i<arr.length-1;i++) {
			minIndex = i;
			for(int j=i;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					minIndex = j ;
					flag = true;
				}
				
			}
			//判断minIndex是否有变化
			if(flag) {
				temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		
		}
		return arr;
	}
}
