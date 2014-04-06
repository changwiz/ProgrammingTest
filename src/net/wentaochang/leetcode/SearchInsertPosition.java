package net.wentaochang.leetcode;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		return searchInsert(A, 0, A.length - 1, target);
	}

	public int searchInsert(int[] A, int left, int right, int target) {
		if (left > right) {
			return left;
		}
		int mid = left + (right - left) / 2;
		if (A[mid] == target) {
			return mid;
		} else if (A[mid] > target) {
			return searchInsert(A, left, mid - 1, target);
		} else {
			return searchInsert(A, mid + 1, right, target);
		}
	}
}
