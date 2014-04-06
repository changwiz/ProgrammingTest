package net.wentaochang.leetcode;
public class MaximalRectangle {
	/* Brute force
	public int maximalRectangle(char[][] matrix) {
		int maxArea = 0;
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return maxArea;
		}
		int width = matrix.length;
		int height = matrix[0].length;
		for (int i = 0; i < width; ++i) {
			for (int j = 0; j < height; ++j) {
				if (maxArea >= (width - i) * (height - j)) {
					return maxArea;
				}
				for (int ii = i; ii < width; ++ii) {
					for (int jj = j; jj < height; ++jj) {
						if (maxArea >= (ii - i + 1) * (jj - j + i)) {
							continue;
						}
						if (isAllOne(i, j, ii, jj, matrix)) {
							maxArea = Math.max(maxArea, (ii - i + 1) * (jj - j + 1));
						}
					}
				}
			}
		}
		return maxArea;
	}

	private boolean isAllOne(int startX, int startY, int endX, int endY, char[][] matrix) {
		for (int k = startX; k <= endX; ++k) {
			for (int l = startY; l <= endY; ++l) {
				if (matrix[k][l] == '0') {
					return false;
				}
			}
		}
		return true;
	}*/
	
	//O(n*n*n)
	public int maximalRectangle(char[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = matrix.length;
		int n = m == 0 ? 0 : matrix[0].length;
		int maxArea = 0;
		for (int i = 0; i < m; i++) {// row
			for (int j = 0; j < n; j++) {// col
				if (matrix[i][j] == '1') {
					int area = maxRectangle(matrix, i, j);
					if (area > maxArea)
						maxArea = area;
				}
			}
		}
		return maxArea;
	}

	//similar to maximal rectangle in histogram
	/*private int maxRectangle(char[][] matrix, int row, int col) {
		int minWidth = Integer.MAX_VALUE;
		int maxArea = 0;
		for (int i = row; i < matrix.length && matrix[i][col] == '1'; i++) {
			int width = 0;
			while (col + width < matrix[row].length && matrix[i][col + width] == '1') {
				width++;
			}
			if (width < minWidth) {
				minWidth = width;
			}
			int area = minWidth * (i - row + 1);
			if (area > maxArea)
				maxArea = area;
		}
		return maxArea;
	}*/
	
	private int maxRectangle(char[][]matrix, int rows, int cols){
	    int minWidth = matrix[rows].length;
	    int maxArea = 0;
	    for(int i=rows;i<matrix.length&&matrix[i][cols] == '1';++i){
	        int width = 0;
	        while(matrix[i][cols+width] == '1' && width+cols<matrix[i].length){
	            width++;
	        }
	        if(width<minWidth){
	            minWidth = width;
	        }
	        int area = minWidth * (i-rows+1);
	        if(area>maxArea){
	            maxArea = area;
	        }
	    }
	    return maxArea;
	    
	}
	//There's another O(n*n) solution, which leverages the largestMaximumHistogram. It can be found at: http://www.cnblogs.com/lichen782/p/leetcode_maximal_rectangle.html
}
