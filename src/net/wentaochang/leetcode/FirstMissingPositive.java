package net.wentaochang.leetcode;

public class FirstMissingPositive {
	//Very tricky question, use array index to represent missing positive, 3-step code
	//(1)move all negative to front (2)mark corresponding index  (3)find first positive,return its index
    public int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0) {
			return 1;
		}
		int index = 0;
		for (int i = 0; i < A.length; ++i) {
			if (A[i] <= 0) {
				if (index != i) {
					int temp = A[i];
					A[i] = A[index];
					A[index] = temp;
				}
				index++;
			}
		}
		for (int i = index; i < A.length; ++i) {
			int abs = Math.abs(A[i]);
			if (abs + index - 1 < A.length) {
				A[abs + index - 1] = -Math.abs(A[abs + index - 1]);
			}
		}
		int i = 0;
		for (i = index; i < A.length; ++i) {
			if (A[i] > 0) {
				return i - index + 1;
			}
		}
		return i - index + 1;
    }
}
