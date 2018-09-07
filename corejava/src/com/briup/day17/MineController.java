package com.briup.day17;

public class MineController {

	public MineController(int N, int M, int mineNumber) {

		MineSweeperData sweeperData = new MineSweeperData(N, M, mineNumber);

		int canvasWidth = 32 * N;
		int canvasHeight = 32 * M;
		MineFrame frame = new MineFrame("Mine", canvasWidth, canvasHeight);

		frame.rend(sweeperData);

	}

}
