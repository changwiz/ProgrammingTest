package net.wentaochang.leetcode;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] table = new int[m][n];
		boolean hasO = false;
		for (int i = 0; i < m; ++i) {
			if (hasO || obstacleGrid[i][0] == 1) {
				table[i][0] = 0;
				hasO = true;
			} else {
				table[i][0] = 1;
			}
		}
		hasO = false;
		for (int i = 0; i < n; ++i) {
			if (hasO || obstacleGrid[0][i] == 1) {
				table[0][i] = 0;
				hasO = true;
			} else {
				table[0][i] = 1;
			}
		}
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				if (obstacleGrid[i][j] == 1) {
					table[i][j] = 0;
				} else {
					table[i][j] = table[i - 1][j] + table[i][j - 1];
				}
			}
		}
		return table[m - 1][n - 1];
	}
}
