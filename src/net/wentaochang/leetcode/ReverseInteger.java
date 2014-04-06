package net.wentaochang.leetcode;

public class ReverseInteger {
	public int reverse(int x) {
		int sign = x < 0 ? -1 : 1;
		int val = Math.abs(x);
		int result = 0;
		while (val > 0) {
			result = 10 * result + val % 10;
			val = val / 10;
		}
		return result * sign;
	}
}
