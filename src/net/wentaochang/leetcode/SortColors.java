package net.wentaochang.leetcode;

public class SortColors {
	//swap , r=0, w=0, b = length-1
	public void sortColors(int[] A) {
		if (A == null || A.length == 0) {
			return;
		}
		int r = 0, w = 0, b = A.length - 1;
		for (w = 0; w <= b;) {
			if (A[w] == 0) {
				swap(A, r, w);
				r++;
				w++;
			} else if (A[w] == 2) {
				swap(A, b, w);
				b--;
			} else {
				w++;
			}
		}
	}

	void swap(int A[], int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
