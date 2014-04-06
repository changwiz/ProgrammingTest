package net.wentaochang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
	// Typical DFS problem, has boolean[] cols and int[] rows, dfs(n,index,res,cols,rows)
	// this approach is wrong, because queens can attack each other in orthogonal direction 
	/*public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> res = new ArrayList<String[]>();
		if (n <= 0) {
			return res;
		}
		int[] rows = new int[n];
		boolean[] cols = new boolean[n];
		dfs(n, 0, res, cols, rows);
		return res;
	}

	private void dfs(int n, int index, ArrayList<String[]> res, boolean[] cols, int[] rows) {
		if (index == n) {
			String[] strs = new String[n];
			char[] arr = new char[n];
			for (int i = 0; i < n; ++i) {
				Arrays.fill(arr, '.');
				arr[rows[i] - 1] = 'Q';
				strs[i] = String.valueOf(arr);
			}
			res.add(strs);
			return;
		}
		for (int i = 0; i < n; ++i) {
			if (!cols[i] && rows[index -1] != i && rows[index-1] != i+2) {
				rows[index] = i + 1;
				cols[i] = true;
				dfs(n, index + 1, res, cols, rows);
				cols[i] = false;
				rows[index] = 0;
			}
		}
	}*/
	
	//pay attention to isValid method
	private static ArrayList<String[]> res = new ArrayList<String[]>();

	private static boolean isValid(int A[], int r) {
		for (int i = 0; i < r; i++) {
			if ((A[i] == A[r]) || (Math.abs(A[i] - A[r]) == (r - i))) {//orthogonal
				return false;
			}
		}
		return true;
	}

	private static void dfs(int A[], int index, int n) {
		if (index == n) {
			String[] strs = new String[n];
			char[] arr = new char[n];
			for (int i = 0; i < n; ++i) {
				Arrays.fill(arr, '.');
				arr[A[i]] = 'Q';
				strs[i] = String.valueOf(arr);
			}
			res.add(strs);
		} else {
			for (int i = 0; i < n; i++) {
				A[index] = i;
				if (isValid(A, index)) {
					dfs(A, index + 1, n);
				}
			}
		}
	}

	public static ArrayList<String[]> solveNQueens(int n) {
		int[] A = new int[n];
		dfs(A, 0, n);
		return res;
	}

	public static void main(String[] args) {
		ArrayList<String[]> res = solveNQueens(3);
		for (String[] i : res) {
			for (String s : i) {
				System.out.println(s);
			}
			System.out.println();
		}
	}
}
