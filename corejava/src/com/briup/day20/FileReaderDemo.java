package com.briup.day20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
	public static void main(String[] args) throws Exception {
		File file = new  File("a.txt");
		FileReader fileReader = new FileReader(file);
//		char c = (char) fileReader.read();
//		System.out.println(c);
//		char[] array = new char[5];
//		fileReader.read(array);
//		
		char[] c = new char[3];
		int len = 0;
		while((len = fileReader.read(c))!=-1) {
			System.out.print(new String(c,0,len));
		}
		fileReader.close();
		
	}

}
