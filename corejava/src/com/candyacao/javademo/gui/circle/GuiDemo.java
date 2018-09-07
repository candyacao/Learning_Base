package com.candyacao.javademo.gui.circle;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GuiDemo {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		//设置大小
		jFrame.setSize(new Dimension(500, 500));
		//窗口的大小不能随意改变
		jFrame.setResizable(false);
		//设置窗口的关闭模式，即再关闭窗口的时候退出程序
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		//将窗口设为可见
		jFrame.setVisible(true);
	}

}
