package com.candyacao.javademo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class FileInputStreamDemo {
	public static void main(String[] args) throws Exception {
		File file = new File("a.txt");
		FileInputStream fis = new FileInputStream(file);
		
	/*	// int read() 从输入流中读取数据的下一个字节。
		int i = 0;
		while((i= fis.read())!= -1) {
			System.out.println((char)i);
		}*/
		
	/*	// int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在数组 b 中。
		byte[] b = new byte[3];
		int i=0;
		while ((i=fis.read(b))!=-1) {
			//System.out.println(Arrays.toString(b));
			 String s=new String(b);
	          System.out.println("  "+s);
		}*/
		
		byte[] array = new byte[3];
		int len = 0;
		StringBuffer stringBuffer = new StringBuffer();
		while ((len = fis.read(array)) != -1) {
			stringBuffer.append(new String(array, 0, len));
		}

		System.out.println(stringBuffer.toString());
		fis.close();

	}

}
