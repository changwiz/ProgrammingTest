package net.wentaochang.leetcode;

public class MaximumSubarray {
	
	//Continuous non-negative sum
	//boundary case: all int are negative, find the largest negative
	public int maxSubArray(int[] A) {
		int max = Integer.MIN_VALUE;
		boolean isCounting = false;
		int sum = 0;
		for (int i = 0; i < A.length; ++i) {
			if (isCounting || A[i] > 0) {
				isCounting = true;
				sum += A[i];
				if (sum >= 0) {
					if (sum > max) {
						max = sum;
					}
				} else {
					isCounting = false;
					sum = 0;
				}
			} else if (A[i] > max) {
				max = A[i];
			}
		}
		return max;
	}
}
