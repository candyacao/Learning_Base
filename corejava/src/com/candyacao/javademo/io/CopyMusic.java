package com.candyacao.javademo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyMusic {
	public static void main(String[] args) throws Exception{
		InputStream is = new FileInputStream(new File("music.mp3")) ;
		OutputStream os = new FileOutputStream(new File("copyMusic.mp3"));
		
		byte[] arr = new byte[1024];
		int len = 0;
		while((len = is.read(arr))!=-1) {
			os.write(arr,0,len);
		}
		os.close();
		is.close();
	}
}
