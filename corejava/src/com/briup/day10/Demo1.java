package com.briup.day10;
/**
 * 内部类：成员内部类，局部内部类，静态内部类，匿名内部类
 * 定义：把一个类被定义在某一个类的内部
 * 成员内部类：其实就是把类定义在其他类的成员位置
 * 内部类在编译过后也会生成.class文件，是以外部类名$内部类名.class去命名的
 * 成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）。
 * @author CLY
 *
 */
public class Demo1 {
	
}

/**
 * B是A的内部类，A是B的外部类或宿主类
 * @author CLY
 *
 */
class Outter{
	 int a =10;
	class Inner{
		 int a =20;
		public void function() {
			 int a =30;
			System.out.println(a);
		}
	}
	
	public void method() {
		
	}
}
