package com.briup.day21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIInputStreamTester {
	public static void main(String[] args)  {
		FileInputStream fis = null;
		int data;
		try {
			fis = new FileInputStream("a.txt");
			while((data = fis.read())!=-1) {
				System.out.print(data+"   ");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	}

}
