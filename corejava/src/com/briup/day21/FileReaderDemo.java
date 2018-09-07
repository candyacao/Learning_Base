package com.briup.day21;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;

public class FileReaderDemo {

	public static void main(String[] args) throws Exception {

		File file = new File("briup.txt");
		Reader reader = new FileReader(file);
		int len = reader.read();
		System.out.println((char) len);

//		char[] array = new char[5];
//		int length = 0;
//		while ((length = reader.read(array)) != -1) {
//			System.out.println(new String(array, 0, length));
//
//		}
		
		char[] array=new char[10];
		reader.read(array, 1, 5);
		System.out.println(Arrays.toString(array));
		

		reader.close();
	}

}
