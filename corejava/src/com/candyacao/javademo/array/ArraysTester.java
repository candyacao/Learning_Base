package com.candyacao.javademo.array;

import java.util.Arrays;

public class ArraysTester {
	/**
	 * 用Arrays类操纵字符串数组
	 */
	public void testStringArray() {
		String[] s1 = {"Tom1","Jack","Mike","Mary","Tom2"};
		String[] s2 = {"Tom1","Jack","Mike","Mary","Tom2"};
		System.out.println("s1是否和s2相等："+Arrays.equals(s1, s2));
		
		Arrays.sort(s1);
		System.out.println("s1排序后，s1和s2是否相等："+Arrays.equals(s1, s2));
		
		System.out.println("Jack在s1数组中的位置："+Arrays.binarySearch(s1, "Jack"));
		System.out.println("Jack在s2数组中的位置："+Arrays.binarySearch(s2, "Jack"));
		System.out.println("s1:"+Arrays.toString(s1));
		System.out.println("s2："+Arrays.toString(s2));
	}
	
	/**
	 * 用Arrays类操纵int数组
	 */
	
	public void testIntArray() {
		int[] a1 = new int[5],a2 = new int[5],a3 = {4,5,6,3,9,4};
		Arrays.fill(a1, 100);
		//把a1数组中的内容拷贝到a2中去
		System.arraycopy(a1, 0, a2, 0, a1.length);
		System.out.println("a1与a2是否相等："+Arrays.equals(a1, a2));
		
		Arrays.sort(a3);
		System.out.println("5在a3数组中的位置："+Arrays.binarySearch(a3, 5));
		
		System.out.println("a1:"+Arrays.toString(a1));
		System.out.println("a2:"+Arrays.toString(a2));
		System.out.println("a3:"+Arrays.toString(a3));
	}
	
	public static void main(String[] args) {
		ArraysTester s = new ArraysTester();
		s.testStringArray();
		s.testIntArray();
	}
}
