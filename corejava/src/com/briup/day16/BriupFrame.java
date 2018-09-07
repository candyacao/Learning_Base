package com.briup.day16;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 鑷畾涔夌殑JFrame绫�
 * 
 * @author yuxiangrousigaifan
 *
 */
public class BriupFrame extends JFrame {

	private static final String EMPTY_NAME = "";
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 500;

	private String title;
	private int canvasWidth;
	private int canvasHeight;

	public BriupFrame() {
		this(EMPTY_NAME, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public BriupFrame(String title) {
		this(title, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public BriupFrame(String title, int canvasWidth, int canvasHeight) {
		super(title);
		this.title = title;
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		initFrame(canvasWidth, canvasHeight);
	}

	/**
	 * 瀵圭獥鍙ｇ殑鍒濆鍖栦唬鐮�
	 * 
	 * @param canvasWidth
	 * @param canvasHeight
	 */
	private void initFrame(int canvasWidth, int canvasHeight) {
		BriupCanvas briupCanvas = new BriupCanvas(true);
		briupCanvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
		setContentPane(briupCanvas);
		pack();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCanvasWidth() {
		return canvasWidth;
	}

	public void setCanvasWidth(int canvasWidth) {
		this.canvasWidth = canvasWidth;
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}

	public void setCanvasHeight(int canvasHeight) {
		this.canvasHeight = canvasHeight;
	}

	private Circle[] circles;

	public void rend(Circle[] circles) {
		this.circles = circles;
		repaint();
	}

	/**
	 * 鐢绘澘閲岄潰鐨勭敾绾�
	 * 
	 * @author yuxiangrousigaifan
	 *
	 */
	class BriupCanvas extends JPanel {

		// 寮�鍚簡鍙岀紦鍐�
		public BriupCanvas(boolean b) {
			super(b);
		}

		/**
		 * 缁樺埗鍥惧舰鐨勬柟娉�
		 */
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			Graphics2D g2d = (Graphics2D) g;

			for (Circle c : circles) {
				GraphicsHelper.strokeCircle(g2d, c.x, c.y, c.r);
			}

		}

//      

	}

}
