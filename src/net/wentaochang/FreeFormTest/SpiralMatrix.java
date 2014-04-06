package net.wentaochang.FreeFormTest;

import java.util.ArrayList;

public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int m = matrix.length;
		int n = matrix[0].length;
		int x = 0;
		int y = 0;

		while (m > 0 && n > 0) {
			if (m == 1) {
				for (int i = 0; i < n; ++i) {
					res.add(matrix[x][y++]);
				}
				break;
			} else if (n == 1) {
				for (int i = 0; i < m; ++i) {
					res.add(matrix[x++][y]);
				}
				break;
			}
			for (int i = 0; i < n - 1; ++i) {
				res.add(matrix[x][y++]);
			}
			for (int i = 0; i < m - 1; ++i) {
				res.add(matrix[x++][y]);
			}
			for (int i = 0; i < n - 1; ++i) {
				res.add(matrix[x][y--]);
			}
			for (int i = 0; i < m - 1; ++i) {
				res.add(matrix[x--][y]);
			}
			x++;
			y++;
			m = m - 2;
			n = n - 2;
		}
		return res;

	}
}
