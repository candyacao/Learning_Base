package com.candyacao.javademo.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 该程序定义了DownThread()线程类，该线程负责读取从start开始，到end结束的所有字节数据，并写入
 * RandomAccessFile对象，这个DownThread线程类的run()方法就是一个简单的输入、输出实现
 * @author candyacao
 * @created 2018年10月14日 上午9:56:31
 */

public class DownUtil {
	// 定义文件下载资源的路径
	private String path;
	// 指出所下载文件的保存位置
	private String targetFile;
	// 定义需要多少个线程下载资源
	private int threadNum;
	// 定义下载的线程对象
	private DownThread[] threads;
	// 定义下载文件的总大小
	private int fileSize;
	
	public DownUtil(String path, String targetFile, int threadNum) {
		this.path = path;
		this.targetFile = targetFile;
		this.threadNum = threadNum;
		threads = new DownThread[threadNum];
		this.targetFile = targetFile;
	}
	/**
	 * download()方法按如下步骤实现多线程下载
	 * 1. 创建URL对象
	 * 2. 获取指定URL对象所指向资源的大小(通过getContentLength()方法获得)，此处用到了URLConnection
	 * 类，该类代表Java应用程序和URL之间的通信链接
	 * 3. 在本地磁盘上创建一个与网络资源具有相同大小的空文件
	 * 4. 计算每个线程应该下载网络资源的哪个部分（从哪个字节开始，到哪个字节结束）
	 * 5. 依次创建、启动多个线程来下载网络资源的指定部分
	 */
	public void download() throws Exception{
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5 * 1000);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, image/pjpeg, "+
		"application/x-shockwave-flash,application/xaml+xml, "+
				"application/vnd.ms-xpsdocument, application/x-ms-xbap, "+
		"application/x-ms-application, application/vnd.ms-execl, "+
				"application/vnd.ms-powerpoint, application/msword, */*");
		conn.setRequestProperty("Accept-Language", "zh-CN");
		conn.setRequestProperty("Charset", "UTF-8");
		conn.setRequestProperty("Connection", "KeepAlive");
		//得到文件大小
		fileSize = conn.getContentLength();
		conn.disconnect();
		int currentPartSize = fileSize / threadNum +1;
		RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
		// 设置本地文件的大小
		file.setLength(fileSize);
		file.close();
		for(int i = 0; i < threadNum; i++) {
			// 计算每个线程下载的开始位置
			int startPos = i * currentPartSize;
			// 每个文件使用RandomAccessFile进行下载
			RandomAccessFile currentPart = new RandomAccessFile(targetFile,"rw");
			// 定义该线程的下载位置
			currentPart.seek(startPos);
			// 创建下载线程
			threads[i] = new DownThread(startPos, currentPartSize, currentPart);
			// 启动下载线程
			threads[i].start();
		}
	}
	
	// 获取下载完成的百分比
	public double getCompleteRate() {
		// 统计多线程已经下载的总大小
		int sumSize = 0;
		for(int i =  0; i < threadNum; i++) {
			sumSize += threads[i].length;
		}
		// 返回已经完成的百分比
		return sumSize * 1.0 / fileSize;
	}
	
	private class DownThread extends Thread{
		//当前线程下载的位置
		private int startPos;
		// 定义当前线程负责下载的文件大小
		private int currentPartSize;
		//当前线程需要下载的文件块
		private RandomAccessFile currentPart;
		// 定义该线程已下载的字节数
		public int length;
		public DownThread(int startPos, int currentPartSize, RandomAccessFile currentPart) {
			this.startPos = startPos;
			this.currentPartSize = currentPartSize;
			this.currentPart = currentPart;
		}
		
		public void run() {
			try {
				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setConnectTimeout(5 * 1000);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, image/pjpeg, "+
				"application/x-shockwave-flash,application/xaml+xml, "+
						"application/vnd.ms-xpsdocument, application/x-ms-xbap, "+
				"application/x-ms-application, application/vnd.ms-execl, "+
						"application/vnd.ms-powerpoint, application/msword, */*");
				conn.setRequestProperty("Accept-Language", "zh-CN");
				conn.setRequestProperty("Charset", "UTF-8");
				InputStream inStream = conn.getInputStream();
				// 跳过startPos个字节，表明该线程只下载自己负责的那部分文件
				inStream.skip(this.startPos);
				byte[] buffer = new byte[1024];
				int hasRead = 0;
				// 读取网络数据，并写入本地文件
				while(length < currentPartSize && (hasRead = inStream.read(buffer)) != -1) {
					currentPart.write(buffer, 0, hasRead);
					// 累计该线程下载的总大小
					length += hasRead;
				}
				currentPart.close();
				inStream.close();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	

}
