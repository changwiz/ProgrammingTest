package net.wentaochang.FreeFormTest;

import java.util.*;

public class BubbleSort {
	public static int[] bubbleSort(int[] arr) {
		int len = arr.length;
		boolean flag = true;
		for (int i = 0; i < len && flag; ++i) {
			flag = false;
			for (int j = 1; j < len - i; ++j) {
				if (arr[j] < arr[j - 1]) {
					flag = true;
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}

		}
		return arr;
	}

	public static void main(String[] args) {
		int[] input = { 5, 8, 2, 3, 5, 1, 2 };
		System.out.println(Arrays.toString(bubbleSort(input)));
	}
}
