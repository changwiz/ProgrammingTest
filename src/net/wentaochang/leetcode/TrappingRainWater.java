package net.wentaochang.leetcode;

public class TrappingRainWater {
	public int trap(int[] A) {
		int water = 0;
		int leftMax = 0;
		int rightMax = 0;
		for (int i = 0; i < A.length; ++i) {
			if (A[i] > leftMax) {
				leftMax = A[i];
			}
			if (A[i] >= rightMax) {
				rightMax = findMax(A, i);
			}
			int min = Math.min(leftMax, rightMax);
			if (min > A[i]) {
				water += min - A[i];
			}
		}
		return water;
	}

	public int findMax(int[] A, int index) {
		int max = 0;
		for (int i = index + 1; i <= A.length - 1; i++) {
			if (A[i] > max) {
				max = A[i];
			}
		}
		return max;
	}
}
