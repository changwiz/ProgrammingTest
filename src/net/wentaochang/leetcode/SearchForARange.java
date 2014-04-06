package net.wentaochang.leetcode;

public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;
		if (A == null || A.length == 0) {
			return res;
		}
		return searchRange(A, 0, A.length - 1, target);
	}

	private int[] searchRange(int[] A, int left, int right, int target) {
		if (left > right) {
			int[] res = new int[2];
			res[0] = -1;
			res[1] = -1;
			return res;
		}
		int mid = left + (right - left) / 2;
		if (A[mid] == target) {
			int[] res = new int[2];
			int j = mid;
			while (j - 1 >= left && A[j - 1] == target) {
				j--;
			}
			res[0] = j;
			j = mid;
			while (j + 1 <= right && A[j + 1] == target) {
				j++;
			}
			res[1] = j;
			return res;
		} else if (A[mid] > target) {
			return searchRange(A, left, mid - 1, target);
		} else {
			return searchRange(A, mid + 1, right, target);
		}
	}
}
