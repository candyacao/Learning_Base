package com.candyacao.javademo.gui.mine;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 扫雷游戏的视图
 * 
 * @author CLY
 *
 */
public class MineFrame extends JFrame {
	private static final String EMPTY_NAME = "";
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 500;

	private String title;
	private int canvasWidth;
	private int canvasHeight;

	public MineFrame() {
		this(EMPTY_NAME, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public MineFrame(String title) {
		this(title, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public MineFrame(String title, int canvasWidth, int canvasHeight) {
		super(title);
		this.title = title;
		this.canvasWidth = canvasWidth;
		this.canvasHeight = canvasHeight;
		initFrame(canvasWidth, canvasHeight);
	}

	/**
	 * 对窗口的初始化代码
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

	/**
	 * 画板里面的画纸
	 * 
	 * @author yuxiangrousigaifan
	 *
	 */
	class BriupCanvas extends JPanel {

		// 开启了双缓冲
		public BriupCanvas(boolean b) {
			super(b);
		}

		/**
		 * 绘制图形的方法
		 */
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			Graphics2D g2d = (Graphics2D) g;
			
			int w=canvasWidth/data.getN();
			int h=canvasHeight/data.getM();
         /**
          * 埋雷
          */
			for(int i=0;i<data.getN();i++) {
				for(int j=0;j<data.getM();j++) {
					if(data.mine(i, j)) {
						GraphicsHelper.drawImage(g2d, MineSweeperData.MINE_IMG_URL, w*i, h*j);
					}else {
						GraphicsHelper.drawImage(g2d, MineSweeperData.BLOCK_IMG_URL, w*i, h*j);
					}
				}
			}
			
 		}

	}

	public String getTitle() {
		return title;
	}

	private MineSweeperData data;

	public void rend(MineSweeperData data) {
		this.data = data;
		repaint();
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
}
