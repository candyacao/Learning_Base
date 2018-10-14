package com.candyacao.javademo.gui.circle;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

/**
 * 画笔的工具类
 * 
 * @author CLY
 *
 */
public class GraphicsHelper {

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

	public static void fillCircle(Graphics2D g2d, int x, int y, int r) {

		Ellipse2D e2d = new Ellipse2D.Float(x - r, y - r, 2 * r, 2 * r);
		g2d.fill(e2d);

	}

	public static void openAA(Graphics2D g2d) {
		RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.addRenderingHints(hints);

	}
	
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
