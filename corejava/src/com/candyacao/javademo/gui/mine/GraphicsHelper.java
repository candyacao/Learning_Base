package com.candyacao.javademo.gui.mine;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;

public class GraphicsHelper {
	/**
	 * 构造器
	 */
	private GraphicsHelper() {
	}

	/**
	 * 设置画笔的颜色
	 * 
	 * @param g2d
	 * @param color
	 */
	public static void setColor(Graphics2D g2d, Color color) {
		g2d.setColor(color);
	}

	/**
	 * 设置画笔的粗度
	 * 
	 * @param g2d
	 * @param width
	 */
	public static void setStrokeWidth(Graphics2D g2d, float width) {
		BasicStroke bs = new BasicStroke(width);
		g2d.setStroke(bs);
	}

	/**
	 * 画一个空心的园
	 * 
	 * @param g2d 画笔
	 * @param x   圆心的横坐标
	 * @param y   圆心的纵坐标
	 * @param r   圆的半径
	 */
	public static void strokeCircle(Graphics2D g2d, int x, int y, int r) {

		Ellipse2D e2d = new Ellipse2D.Float(x - r, y - r, 2 * r, 2 * r);
		g2d.draw(e2d);

	}

	/**
	 * 画一个实心的圆
	 * @param g2d     画笔
	 * @param x        圆心x的坐标
	 * @param y        圆心y的坐标
	 * @param r         圆的半径
	 */
	public static void fillCircle(Graphics2D g2d, int x, int y, int r) {

		Ellipse2D e2d = new Ellipse2D.Float(x - r, y - r, 2 * r, 2 * r);
		g2d.fill(e2d);

	}
	
	/**
	 * 贴图片
	 * @param g2d      画笔
	 * @param img    图片位置信息
	 * @param x         要贴图片位置的x坐标
	 * @param y         要贴图片位置的y坐标
	 */
	public static void drawImage(Graphics2D g2d,String img,int x,int y) {
		ImageIcon icon = new ImageIcon(img);
		Image image = icon.getImage();
		g2d.drawImage(image, x, y, null);

	}

	/**
	 * 开启双缓存
	 * @param g2d       画笔
	 */
	public static void openAA(Graphics2D g2d) {
		RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.addRenderingHints(hints);

	}
	
	/**
	 * 设置停顿时间
	 * @param time
	 */
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
