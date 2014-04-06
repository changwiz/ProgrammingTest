package net.wentaochang.careercup;

public class MergeTwoSortedArray {
	public static int[] mergeSortedArray(int[] A, int[] B, int m, int n) {
		if (A == null || m == 0) {
			return B;
		}
		if (B == null || n == 0) {
			return A;
		}
		int k = m + n - 1;
		int i = m - 1;
		int j = n - 1;
		while (k >= 0 && i >= 0 && j >= 0) {
			if (A[i] < B[j]) {
				A[k] = B[j];
				j--;
			} else {
				A[k] = A[i];
				i--;
			}
			k--;
		}
		if (k < 0) {
			return A;
		}
		if (i < 0) {
			for (; k >= 0 && j >= 0; k--, j--) {
				A[k] = B[j];
			}
		}
		if (j < 0) {
			for (; k >= 0 && i >= 0; k--, i--) {
				A[k] = A[i];
			}
		}
		return A;
	}
	
	public static void main(String[] args) {
		int[] t = mergeSortedArray(new int[]{4,5,7,9,0,0}, new int[]{1,10},4,2);
		System.out.println(t);
	}
	
}
