package net.wentaochang.careercup;

public class SubMatrixWithLargestSum {
	// Should use dp, precompute is the key
	public static int getSubMatrix(int[][] matrix) {
		int max = Integer.MIN_VALUE;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] t = precomputeMatrix(matrix);
		for (int row1 = 0; row1 < m; ++row1) {
			for (int row2 = row1; row2 < m; row2++) {
				for (int col1 = 0; col1 < n; col1++) {
					for (int col2 = col1; col2 < n; col2++) {
						int sum = t[row2][col2] - t[row2][col1] - t[row1][col2] + t[row1][col1];
						if (sum > max) {
							max = sum;
						}
					}
				}
			}
		}
		return max;
	}

	private static int[][] precomputeMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] t = new int[m][n];
		t[0][0] = matrix[0][0];
		for (int i = 1; i < m; ++i) {
			t[i][0] = t[i - 1][0] + matrix[i][0];
		}
		for (int i = 1; i < n; ++i) {
			t[0][i] = t[0][i - 1] + matrix[0][i];
		}
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				t[i][j] = t[i - 1][j] + t[i][j - 1] - t[i - 1][j - 1] + matrix[i][j];
			}
		}
		return t;
	}

}
