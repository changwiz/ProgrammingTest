package net.wentaochang.leetcode;

public class NQueensII {
	private int res;

	private boolean isValid(int A[], int r) {
		for (int i = 0; i < r; i++) {
			if ((A[i] == A[r]) || (Math.abs(A[i] - A[r]) == (r - i))) {
				return false;
			}
		}
		return true;
	}

	private void nqueens(int A[], int cur, int n) {
		if (cur == n) {
			res++;
			return;
		} else {
			for (int i = 0; i < n; i++) {
				A[cur] = i;
				if (isValid(A, cur)) {
					nqueens(A, cur + 1, n);
				}
			}
		}
	}

	public int totalNQueens(int n) {
		res = 0;
		int[] A = new int[n];
		nqueens(A, 0, n);
		return res;
	}
}
