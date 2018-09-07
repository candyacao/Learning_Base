package com.candyacao.javademo.gui.mine;

/**
 * 数据
 * 
 * @author CLY
 *
 */
public class MineSweeperData {

	public static final String BLOCK_IMG_URL = "resources/block.png";
	public static final String FLAG_IMG_URL = "resources/flag.png";
	public static final String MINE_IMG_URL = "resources/mine.png";

	public static String numberImgUrl(int number) {

		if (number < 0 || number > 8) {
			throw new IllegalArgumentException("数字只能是0-8");
		}
		return "resources/" + number + ".png";
	}

	private int N;// 有N行
	private int M;// 有M列
	private int mineNumber;// 有几颗雷

	private boolean[][] mines;

	public MineSweeperData(int N, int M, int mineNumber) {

		if (N < 0 || M < 0) {
			throw new IllegalArgumentException("格子数不能小于0");
		}
		if (mineNumber < 0 || mineNumber > N * M) {
			throw new IllegalArgumentException("雷的数量不能小于0或者大于格子的总数");
		}
		this.N = N;
		this.M = M;
		this.mineNumber = mineNumber;
		mines = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				mines[i][j] = false;
			}
		}

		randomMine(mineNumber);

	}

	/**
	 * 随机布雷的算法
	 */
	public void randomMine(int mineNumber) {
		
		
		
		for (int i = 0; i < mineNumber; i++) {
			int x = i % N;
			int y = i / N;
			mines[x][y] = true;
		}
		
		for(int i=0;i<mineNumber;i++) {
			int x1=i%N;
			int y1=i/N;
			int x2 = (int) (Math.random() * N);
			int y2 = (int) (Math.random() * M);
			swap(x1, y1, x2, y2);
		}
		
		
		
		

//		for (int i = 0; i < mineNumber; i++) {
//			int x = i % N;
//			int y = i / N;
//			mines[x][y] = true;
//		}
//
//		int count = 10;
//		for (int i = 0; i < N*M; i++) {
//			int x1 = (int) (Math.random() * N);// [0,N)
//			int y1 = (int) (Math.random() * M);// [0,M)
//			int x2 = (int) (Math.random() * N);
//			int y2 = (int) (Math.random() * M);
//			swap(x1, y1, x2, y2);
//
//		}

		// 虽然之前的做法已经满足了不少雷的需求，但是因为有死循环，太影响效率。
//		for (int i = 0; i < mineNumber; i++) {
//			while (true) {
//				int x = (int) (Math.random() * N);// [0,N)
//				int y = (int) (Math.random() * M);// [0,M)
//				if (!mines[x][y]) {
//					mines[x][y] = true;
//					break;
//				}
//			}
//		}

	}

	private void swap(int x1, int y1, int x2, int y2) {
		boolean b = mines[x1][y1];
		mines[x1][y1] = mines[x2][y2];
		mines[x2][y2] = b;
	}

	public boolean mine(int x, int y) {
		return mines[x][y];
	}

	public int getN() {
		return N;
	}

	public int getM() {
		return M;
	}

}
