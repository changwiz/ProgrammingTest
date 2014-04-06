package net.wentaochang.leetcode;

public class SqureRoot {
	public static int sqrt(int x) {
		long high = x;
		long low = 0;
		if (x <= 0) {
			return 0;
		}
		if (x == 1) {
			return 1;
		}
		while (high - low > 1) {
			long mid = low + (high - low) / 2;
			if (mid * mid <= x) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return (int) low;
	}

	public static void main(String[] args) {
		sqrt(10);
	}
}
