package net.wentaochang.careercup;

public class SubSquareWithBlackBorder {
	// white: 0; black:1
	public static int getSubSquare(int[][] matrix) {
		int largestSize = 0;
		int n = matrix.length;
		for (int i = 0; i < n - largestSize; ++i) {
			for (int j = 0; j < n - largestSize; ++j) {
				int size = n - j;
				while (size > largestSize) {
					if (isSubSquare(matrix, j, i, size)) {
						largestSize = size;
					} else {
						size--;
					}
				}
			}
		}

		return largestSize;

	}

	private static boolean isSubSquare(int[][] matrix, int x, int y, int size) {
		// top and bottom edge
		for (int i = y; i <= matrix.length - 1 && i <= y + size - 1; ++i) {
			if (matrix[x][i] == 0) {
				return false;
			}

			if (matrix[x + size - 1][i] == 0) {
				return false;
			}
		}

		// left and right edge
		for (int i = x; i <= matrix.length - 1 && i <= x + size - 1; ++i) {
			if (matrix[i][y] == 0) {
				return false;
			}

			if (matrix[i][y + size - 1] == 0) {
				return false;
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		int[][]matrix = {{0,0,0,0},{0,0,1,1},{0,0,1,1},{0,0,0,0}};
		System.out.println(getSubSquare(matrix));
	}
}
