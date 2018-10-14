package com.candyacao.javademo.io;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class FileDemo {
	public static void main(String[] args) throws URISyntaxException {
		File file=new File(new URI("file:///E:/project/JavaDemo/pom.xml"));
		System.out.println(file);
	}

}
