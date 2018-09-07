package com.briup.day20;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\CLY\\Desktop\\briup");
    	System.out.println(file.createNewFile());
//		System.out.println(file.delete());
		
//		file.renameTo(new File("C:\\Users\\CLY\\Desktop\\com"));
//		System.out.println(file.canWrite());
//		System.out.println(file.canRead());
//		System.out.println(file.canExecute());
//		System.out.println(file.exists());
		
		long time = file.lastModified();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH-mm-ss");
		Date date = new Date(time);
		System.out.println(simpleDateFormat.format(date));

		System.out.println(time);
	}

}
