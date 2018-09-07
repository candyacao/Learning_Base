package com.briup.day11;
/**
 * 字符串的应用
 * @author CLY
 *
 */
public class Demo {
	public static void main(String[] args) {
		String s = "java";
		char c = s.charAt(1);
		System.out.println(c);
		
		String s1 = "厉害了，我的国";
		boolean b = s1.contains("国");
		
		String s2 = s1.replace("国", "xxx");
		
		String s3 = "";
		boolean bc = s3.isEmpty();
		
				
	}

}
