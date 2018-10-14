package com.candyacao.javademo.net;

public class MultiThreadDown {
	public static void main(String[] args) throws Exception{
		// 初始化DownUtil对象
		final DownUtil downUtil = new DownUtil("http://ogp.me/logo.png", "a.png", 4);
		// 开始下载
		downUtil.download();
		new Thread(() -> {
			// 每隔0.1秒查询一次任务的完成进度，GUI程序中可根据该进度来绘制进度条
			System.out.println("已完成："+downUtil.getCompleteRate());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
