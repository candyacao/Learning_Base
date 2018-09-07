package com.briup.day21;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.crypto.Data;

public class FormatDataIO {
	public static void main(String[] args) throws IOException {
		FileOutputStream out1 = new FileOutputStream("a.txt");
		BufferedOutputStream out2 = new BufferedOutputStream(out1);
		DataOutputStream outputStream = new DataOutputStream(out2);
		outputStream.writeByte(-12);
		outputStream.writeLong(12);
		outputStream.writeChar('1');
		outputStream.writeUTF("บร");
		outputStream.close();
		
		InputStream in1 = new FileInputStream("a.txt");
		BufferedInputStream in2 = new BufferedInputStream(in1);
		DataInputStream inputStream = new DataInputStream(in2);
		System.out.print(inputStream.readByte()+" ");
		System.out.print(inputStream.readLong()+" ");
		System.out.print(inputStream.readChar()+" ");
		System.out.print(inputStream.readUTF()+" ");
		inputStream.close();
	}

}
