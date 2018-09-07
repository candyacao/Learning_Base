package com.briup.day21;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayTester {
	public static void main(String[] args) {
		byte[] buff = new byte[] {2,15,67,-1,-9,-9};
		ByteArrayInputStream in = new ByteArrayInputStream(buff,1,4);
		int date = 0;
		while((date=in.read())!=-1) {
			System.out.print(date+"   ");
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}


