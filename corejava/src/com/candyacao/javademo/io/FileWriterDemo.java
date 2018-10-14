package com.candyacao.javademo.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterDemo {

	public static void main(String[] args) throws Exception {

		File file = new File("briup.txt");
		Writer writer = new FileWriter(file);
		writer.write("跟着我左手右手一个慢动作，右手左手慢动作重播");
		writer.close();

	}

}
