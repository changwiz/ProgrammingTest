package net.wentaochang.leetcode;

public class SearchInRotatedSortedArray {
	public static int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}
		return search(A, 0, A.length - 1, target);
	}

	private static int search(int[] A, int left, int right, int target) {
		if (left > right) {
			return -1;
		}
		int mid = left + (right - left) / 2;
		if (A[mid] == target) {
			return mid;
		} else if (A[left] <= A[mid]) {
			if (target < A[mid]&&target>=A[left]) {
				return search(A, left, mid - 1, target);
			} else {
				return search(A, mid + 1, right, target);
			}
		} else {
			if (target > A[mid] && target <= A[right]) {
				return search(A, mid + 1, right, target);
			} else {
				return search(A, left, mid - 1, target);
			}
		}
	}

	public static void main(String[] args) {
		int[] A = { 4, 5, 6, 7, 8, 1, 2, 3 };
		System.out.println(search(A, 8));
	}
}
