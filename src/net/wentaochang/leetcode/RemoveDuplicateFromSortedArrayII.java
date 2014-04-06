package net.wentaochang.leetcode;
import java.util.Arrays;

public class RemoveDuplicateFromSortedArrayII {
	public static int removeDuplicates(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int duplicates = -1;
		int count = 0;

		for (int i = 1; i < A.length; i++) {
			int curr = A[i];

			if (curr == A[i - 1] && count >= 1) {
				if (duplicates == -1) {
					duplicates = i;
				}
			} else {
				if (curr == A[i - 1]) {
					count++;
				} else {
					count = 0;
				}
				if (duplicates != -1) {
					A[duplicates] = curr;
					duplicates++;
				}
			}
		}
		if(duplicates != -1) {
			A = Arrays.copyOf(A, duplicates);
		}
		return A.length;
	}
	
	public static void main(String[] args) {
		int[]A= {1,1,1};
		removeDuplicates(A);
	}
}
