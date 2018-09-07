package com.briup.day20;

import java.io.File;

public class Test1 {
	public static void main(String[] args) {
		
			File file = new File("E:\\杰普");
			list(file);
		}

		/**
		 * 对某一个文件夹的遍历
		 * 
		 * @param file
		 */
		public static void list(File file) {

			File[] files = file.listFiles();
			for (File f : files) {
				System.out.println(f.getAbsolutePath());
				if (f.isDirectory()) {
					System.err.println();
					list(f);
				}
			}

		}
	}

