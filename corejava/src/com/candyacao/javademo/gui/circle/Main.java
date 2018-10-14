package com.candyacao.javademo.gui.circle;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JFrame;

public class Main {
	
	private static final int CANVAS_WIDTH = 500;
	private static final int CANVAS_HEIGHT = 500;
	private static final int CIRCLE_COUNT = 10;
	private static final int CIRCLE_R =50;
	
	public static boolean isPalse = false;
	
	private static Circle[] circles = new Circle[CIRCLE_COUNT];
	private static BriupJFrame briupJFrame;
	
	
	public static void main(String[] args) {
		//给画板添加键盘的响应事件
		briupJFrame = new BriupJFrame("hello",CANVAS_WIDTH,CANVAS_HEIGHT);
		MykeyListener mykeyListener = new MykeyListener();
		briupJFrame.addKeyListener(mykeyListener);
		briupJFrame.addMouseListener(new MyMouseListener());
		for(int i = 0;i<CIRCLE_COUNT;i++) {
			//圆心坐标的随机范围应该是[r-------->w-r]
			
			int x = (int)(Math.random()*(CANVAS_WIDTH-2*CIRCLE_R)+CIRCLE_R);
			int y = (int)(Math.random()*(CANVAS_HEIGHT-2*CIRCLE_R)+CIRCLE_R);
			//int r = (int)(Math.random()*21+30);
//			int vx = (int)(Math.random()*11-5);
//			int vy = (int)(Math.random()*11-5);
			
			int vx = randomSpeed();
			int vy = randomSpeed();
			Circle circle = new Circle(x, y, CIRCLE_R, vx, vy);
			circles[i] = circle;
		}
		
		new Thread() {
			public void run() {
				while (true) {
					try {
						sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					briupJFrame.render(circles);
					for(Circle circle:circles) {
						if(!isPalse) {
						circle.move(CIRCLE_R, CIRCLE_R, CANVAS_WIDTH - CIRCLE_R, CANVAS_HEIGHT - CIRCLE_R);
						}
					}
				}
			}
		}.start();
		
	}
	
	/**
	 * 创建一个不能随机出0的方法
	 * @return
	 */
	public static int randomSpeed() {
		//int[]  array = {-5,-4,-3,-2,-1,1,2,3,4,5};
		int speed = (int)(Math.random()*11-5);
		if(speed == 0) {
			return randomSpeed();
		}
		return speed;
	}
	
	
	static class MykeyListener extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			
			if(e.getKeyChar() == ' ') {
				isPalse = !isPalse;
			}
			super.keyReleased(e);
		}
	}
	
	static class MyMouseListener extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			Point point = e.getPoint();
			System.out.println(point.getX() + "  " + point.getY());
			e.translatePoint(0, -(briupJFrame.getBounds().height-briupJFrame.getCanvasHeight()));
			for(Circle circle:circles) {
			
				boolean b  =  circle.method(e.getX(), e.getY());
				if(b == true) {
					circle.isStroke = !circle.isStroke;
				}
			}
		}
	}
	
}
