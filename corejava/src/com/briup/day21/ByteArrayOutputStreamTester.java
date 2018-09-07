package com.briup.day21;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTester {
	public static void main(String[] args) throws  IOException {
		ByteArrayOutputStream out  = new ByteArrayOutputStream();
		out.write("ฤ๚บร".getBytes("UTF-8"));
		byte[] buff = out.toByteArray();
		out.close();
		
		ByteArrayInputStream in = new ByteArrayInputStream(buff);
		int len = in.available();
		byte[] buffIn = new byte[len];
		in.read(buffIn);
		in.close();
		System.out.println(new String(buffIn,"UTF-8"));
	}

}
