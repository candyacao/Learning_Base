package com.briup.day08;
/**
 * 类加载：某一个类在首次使用的时候，会先完成类加载的操作(方法区)
 * 静态变量一般不会用private修饰，可直接通过类名.变量名访问
 * 
 * @author CLY
 *
 */
public class Demo3 {
	public static void main(String[] args) {
		
	}

}

 class Student {
	private String name;
	private int age;
	private static char sex;//static不会影响权限，加了Static会被类的所有实例共享
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
	
}