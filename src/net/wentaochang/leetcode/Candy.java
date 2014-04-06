package net.wentaochang.leetcode;

public class Candy {
	//from left, get number of continuous increasing integers; from right, get number of continuous increasing integers
	// sum the maximum of each position
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		}
		int[] left = new int[ratings.length], right = new int[ratings.length];
		left[0] = 1;
		for (int i = 1; i < ratings.length; ++i) {
			if (ratings[i] > ratings[i - 1]) {
				left[i] = left[i - 1] + 1;
			} else {
				left[i] = 1;
			}
		}
		right[ratings.length - 1] = 1;
		for (int i = ratings.length - 2; i >= 0; --i) {
			if (ratings[i] > ratings[i + 1]) {
				right[i] = right[i + 1] + 1;
			} else {
				right[i] = 1;
			}
		}
		int sum = 0;
		for (int i = 0; i < ratings.length; ++i) {
			sum += Math.max(left[i], right[i]);
		}
		return sum;
	}
}
