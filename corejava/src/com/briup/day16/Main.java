package com.briup.day16;

public class Main {

	public static final int CIRCLE_COUNT = 10;// 圆的个数
	public static final int CANVAS_WIDTH = 600;
	public static final int CANVAS_HEIGHT = 600;
	public static final int CIRCLE_R = 50;

	public static void main(String[] args) {

		BriupController controller = new BriupController(CANVAS_WIDTH, CANVAS_HEIGHT, CIRCLE_COUNT, CIRCLE_R);

	}

}
