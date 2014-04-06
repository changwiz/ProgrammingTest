package net.wentaochang.leetcode;

public class SpiralMatrixII {
	//similar to spiral matrix problem
	public int[][] generateMatrix(int n) {
		int[][] res = {};
		if (n <= 0) {
			return res;
		}
		res = new int[n][n];
		int x = 0;
		int y = 0;
		int count = 1;

		while (n > 0) {
			if (n == 1) {
				res[x][y] = count;
			}
			// move right
			for (int i = 0; i < n - 1; ++i) {
				res[x][y++] = count++;
			}
			// move down
			for (int i = 0; i < n - 1; ++i) {
				res[x++][y] = count++;
			}
			// move left
			for (int i = 0; i < n - 1; ++i) {
				res[x][y--] = count++;
			}
			// move up
			for (int i = 0; i < n - 1; ++i) {
				res[x--][y] = count++;
			}
			x = x + 1;
			y = y + 1;
			n = n - 2;
		}
		return res;
	}
}
