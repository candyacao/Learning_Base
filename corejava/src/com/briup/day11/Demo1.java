package com.briup.day11;
/**
 * 基本类型与包装类的转换
 * @author CLY
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		Integer i1 = 128;
		Integer i2 = 128;
		Integer i3 = 10;
		Integer i4 = 10;
		// 如果范围没有超出，在赋值时不会再new对象
		System.out.println(i1 == i2);// f
		System.out.println(i3 == i4);// t
		
		
		
		
		Double d1= 128.14;
		Double d2= 128.14;
		Double d3= 3.14;
		Double d4= 3.14;
		//每次运行都new对象
		System.out.println(d1 == d2);// f
		System.out.println(d3 == d4);// f
		
		
		Boolean b1 = true;
		Boolean b2 = true;
		Boolean b3 = false;
		Boolean b4 = false;
		//里面是常量，所以不用new对象
		System.out.println(b1==b2);
		System.out.println(b3==b4);
		
		
		//集合里面只能存放引用数据类型
	}
}
