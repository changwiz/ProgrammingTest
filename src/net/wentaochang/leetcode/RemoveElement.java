package net.wentaochang.leetcode;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int emptyStart = -1;
		for (int i = 0; i < A.length; ++i) {
			int val = A[i];
			if (val == elem) {
				if (emptyStart == -1) {
					emptyStart = i;
				}
			} else if (emptyStart != -1) {
				A[emptyStart] = A[i];
				emptyStart++;
			}
		}
		if (emptyStart == -1) {
			return A.length;
		} else {
			return emptyStart;
		}
	}
}
