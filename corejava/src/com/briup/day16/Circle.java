package com.briup.day16;

public class Circle {

	/**
	 * 鍦嗗績鐨勫潗鏍�
	 */
	int x;
	int y;
	int r;// 鍗婂緞
	/**
	 * 姘村钩鍜屽瀭鐩存柟鍚戜笂鐨勪袱涓�熷害
	 */
	int vx;
	int vy;

	public Circle(int x, int y, int r, int vx, int vy) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.vx = vx;
		this.vy = vy;
	}

	public void move(int minx, int miny, int maxx, int maxy) {

		 

	 

		x += vx;
		y += vy;
		check(minx, miny, maxx, maxy);
	}

	/**
	 * 妫�娴嬭竟鐣岀鎾�
	 */
	public void check(int minx, int miny, int maxx, int maxy) {

		 vx=((x<=minx)||x>=maxx?-vx:vx);
		 vy=((y<=miny)||y>=maxy?-vy:vy);

	}

}
