package net.wentaochang.leetcode;

public class PlusOne {
	//Pay attention to clear carry
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return digits;
		}
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; --i) {
			if (digits[i] == 9 && carry == 1) {
				digits[i] = 0;
				carry = 1;
			} else {
				digits[i] += carry;
				carry = 0;
				break;
			}
		}
		if (carry == 1) {
			int[] result = new int[digits.length + 1];
			for (int i = 1; i < digits.length + 1; ++i) {
				result[i] = digits[i - 1];
			}
			result[0] = carry;
			return result;
		} else {
			return digits;
		}
	}
}
