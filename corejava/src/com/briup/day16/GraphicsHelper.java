package com.briup.day16;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

/**
 * 鐢荤瑪鐨勫伐鍏风被
 * 
 * @author yuxiangrousigaifan
 *
 */
public class GraphicsHelper {

	private GraphicsHelper() {
	}

	/**
	 * 璁剧疆鐢荤瑪鐨勯鑹�
	 * 
	 * @param g2d
	 * @param color
	 */
	public static void setColor(Graphics2D g2d, Color color) {
		g2d.setColor(color);
	}

	/**
	 * 璁剧疆鐢荤瑪鐨勭矖搴�
	 * 
	 * @param g2d
	 * @param width
	 */
	public static void setStrokeWidth(Graphics2D g2d, float width) {
		BasicStroke bs = new BasicStroke(width);
		g2d.setStroke(bs);
	}

	/**
	 * 鐢讳竴涓┖蹇冪殑鍥�
	 * 
	 * @param g2d 鐢荤瑪
	 * @param x   鍦嗗績鐨勬í鍧愭爣
	 * @param y   鍦嗗績鐨勭旱鍧愭爣
	 * @param r   鍦嗙殑鍗婂緞
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
