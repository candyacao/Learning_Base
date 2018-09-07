package com.briup.day20;

import java.io.File;
import java.io.InputStream;
import java.io.FilenameFilter;

public class FileDemo1 {
	public static void main(String[] args) {

		File file = new File("C:\\Users\\CLY\\Desktop\\resources");
                                       //C:\\Users\\CLY\\Desktop\\resources
		String[] array=file.list(new FilenameFilter() {
			  
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".png");
			}
		});
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		
	}
}
