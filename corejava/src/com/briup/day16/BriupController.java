package com.briup.day16;


import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BriupController {

	private BriupFrame briupFrame;

	/**
	 * 圆的容器
	 */
	public static Circle[] circles;

	public boolean isPause = false;

	public BriupController(int CANVAS_WIDTH, int CANVAS_HEIGHT, int CIRCLE_COUNT, int CIRCLE_R) {
		briupFrame = new BriupFrame("Welcome", CANVAS_WIDTH, CANVAS_HEIGHT);

		briupFrame.addKeyListener(new MyKeyListener());
		briupFrame.addMouseListener(new MyMouseListener());

		circles = new Circle[CIRCLE_COUNT];

		for (int i = 0; i < circles.length; i++) {
			int x = (int) (Math.random() * (CANVAS_WIDTH - 2 * CIRCLE_R + 1) + CIRCLE_R);// [R---W-R]
			int y = (int) (Math.random() * (CANVAS_HEIGHT - 2 * CIRCLE_R + 1) + CIRCLE_R);// [R---H-R]
			int vx = randomSpeed();// 1-0.1
			int vy = randomSpeed();// 1
			circles[i] = new Circle(x, y, CIRCLE_R, vx, vy);
		}

		new Thread() {
			public void run() {
				while (true) {
					briupFrame.rend(circles);
					GraphicsHelper.sleep(20);
					for (Circle circle : circles) {
						if (!isPause) {
							circle.move(CIRCLE_R, CIRCLE_R, CANVAS_WIDTH - CIRCLE_R, CANVAS_HEIGHT - CIRCLE_R);
						}
					}
				}

			};

		}.start();
	}

	public int randomSpeed() {

		int speed = (int) (Math.random() * 11 - 5);// [-5,5]
		if (speed == 0) {
			return randomSpeed();
		}
		return speed;

	}

	class MyKeyListener extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyChar() == ' ') {
				isPause = !isPause;
			}

		}

	}

	class MyMouseListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			Point point = e.getPoint();
			System.out.println(point.getX() + "  " + point.getY());
		}

	}

}
