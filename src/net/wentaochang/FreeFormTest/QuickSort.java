package net.wentaochang.FreeFormTest;

public class QuickSort {
	public static void sort(int[] arr) {
		if (arr == null || arr.length == 0 || arr.length == 1) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int start, int end) {
		int i = start, j = end;
		int pivot = start + (end - start) / 2; // avoid overflow, use start +
												// (end-start)/2
		while (i <= j) {
			while (arr[i] < arr[pivot]) {
				i++;
			}
			while (arr[i] > arr[pivot]) {
				j--;
			}
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if (start < j) {
			quickSort(arr, start, j);
		}
		if (i < end) {
			quickSort(arr, i, end);
		}
	}

	public static void main(String[] args) {
		int[] test = { 5, 3 };
		sort(test);
	}
}
