package net.wentaochang.careercup;

public class TrailingZerosInNFactorial {
	public static int numberOfTrailingZeros(int n) {
		int count = 0;
		if (n < 0) {
			return -1;
		}
		for (int i = 5; n / 5 > 0; i = i * 5) {
			count += n / 5;
		}
		return count;
	}
}
