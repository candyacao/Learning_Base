package com.candyacao.javademo.gui.circle;
/**
 * 数据
 * @author CLY
 *
 */
public class Circle {
	private int x;
	private int y;
	private int vx;
	private int vy;
	private int r;
	
	public boolean isStroke = false;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getVx() {
		return vx;
	}
	public void setVx(int vx) {
		this.vx = vx;
	}
	public int getVy() {
		return vy;
	}
	public void setVy(int vy) {
		this.vy = vy;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	
	public boolean method(int mX,int mY) {
		return (mX-x)*(mX-x)+(mY-y)*(mY-y)<=r*r;
	}
	
	
	public Circle(int x,int y,int r,int vx,int vy) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.vx  = vx;
		this.vy = vy;
	}
	
	public void move(int minx,int miny,int maxx,int maxy) {
		x += vx;
		y += vy;
		check(minx,miny,maxx,maxy);
	}
	
	public void check(int minx,int miny,int maxx,int maxy) {
		vx = (x<=minx||x>=maxx) ?-vx:vx;
		vy = (y<=minx||y>=maxx) ?-vy:vy;
	}

}
