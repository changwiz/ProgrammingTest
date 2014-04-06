package net.wentaochang.leetcode;

public class StringToInteger {
	//(1) minus (2) pay attention to overflow, use long to contain value
    public int atoi(String str) {
		if (str == null) {
			return 0;
		}
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		}
		boolean negative = false;
		long result = 0;
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			int value = 0;
			if (c >= '0' && c <= '9') {
				value = c - '0';
				result = result * 10 + value;
			} else if (i == 0 && (c == '+' || c == '-')) {
				negative = c == '-' ? true : false;
			} else {
				break;
			}
		}
		if (result == 0) {
			return 0;
		} else if (negative) {
			result = -1 * result;
			if (result >= Integer.MIN_VALUE) {
				return (int) result;
			} else {
				return Integer.MIN_VALUE;
			}
		} else {
			if (result <= Integer.MAX_VALUE) {
				return (int) result;
			} else {
				return Integer.MAX_VALUE;
			}
		}
    }
}
