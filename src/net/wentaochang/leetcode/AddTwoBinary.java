package net.wentaochang.leetcode;

public class AddTwoBinary {
	//Padding first
	public String addBinary(String a, String b) {
		if (a == null || a.length() == 0) {
			return b;
		} else if (b == null || b.length() == 0) {
			return a;
		}
		int m = a.length();
		int n = b.length();
		if (m > n) {
			for (int i = 0; i < m - n; ++i) {
				b = "0" + b;
			}
		} else if (m < n) {
			for (int i = 0; i < n - m; ++i) {
				a = "0" + a;
			}
		}
		int carry = 0;
		String result = "";
		for (int i = a.length() - 1; i >= 0; --i) {
			int numA = a.charAt(i) - '0';
			int numB = b.charAt(i) - '0';
			int r = numA + numB + carry;
			result = r % 2 + result;
			carry = r / 2;
		}
		if (carry == 1) {
			result = carry + result;
		}
		return result;
	}
}
