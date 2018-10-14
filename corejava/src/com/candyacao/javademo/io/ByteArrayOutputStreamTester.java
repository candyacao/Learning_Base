package com.candyacao.javademo.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTester {
	public static void main(String[] args) throws  IOException {
		ByteArrayOutputStream out  = new ByteArrayOutputStream();
		out.write("您好".getBytes("UTF-8"));
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
