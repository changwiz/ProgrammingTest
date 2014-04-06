package net.wentaochang.leetcode;
public class MinimumPathSum {
	public static int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return -1;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] table = new int[m][n];
		table[0][0] = grid[0][0];
		for (int i = 1; i < m; ++i) {
			table[i][0] = table[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < n; ++i) {
			table[0][i] = table[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				table[i][j] = Math.min(table[i - 1][j], table[i][j - 1]) + grid[i][j];
			}
		}
		return table[m - 1][n - 1];
	}
	
	public static void main(String[]args){
		int [][]grid={{1,2},{1,1}};
		System.out.println(minPathSum(grid));
	}
}
