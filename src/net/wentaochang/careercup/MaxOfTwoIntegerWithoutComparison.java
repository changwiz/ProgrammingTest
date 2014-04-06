package net.wentaochang.careercup;

public class MaxOfTwoIntegerWithoutComparison {
	public static int max(int a, int b) {
		int c = a - b;
		int k = (c >> 31) & 0x1;
		int max = a + k * (a - b);
		return max;
	}
}
