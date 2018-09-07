package com.candyacao.javademo.algorithm;

/**
 * 冒泡排序
 * @author CLY
 *
 */
public class BubbleSort {
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
	 * 冒泡排序
	 * @param arr：需要进行排序的数组
	 * @return：排好序的数组
	 */
	public static int[] arraySort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			//设置一个flag，用于标记当内层循环经过此轮循环后是否有发生交换
			boolean flag = true;
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = false;
				}
			}
			//如果flag为true，证明上一轮没有再发生交换，此时可以结束循环，不必再进行
			if(flag) {
				break;
			}
		}
		return arr;
	}
	

}
