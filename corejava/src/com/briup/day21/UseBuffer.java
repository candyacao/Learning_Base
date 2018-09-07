package com.briup.day21;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class UseBuffer {
	
	public static void main(String[] args) {
		final int SIZE = 1024;
		FileInputStream fis = null;
		FileOutputStream fos=null;
		try {
			fis = new FileInputStream("a.txt");
			fos = new FileOutputStream("briup.txt");
			
			byte[] buf = new byte[1024];
			int len = 0;
			
			while((len = fis.read(buf))!=-1) {
				fos.write(buf, 0, len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}	
