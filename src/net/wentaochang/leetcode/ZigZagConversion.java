package net.wentaochang.leetcode;

public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if (s == null || s.length() == 0) {
			return "";
		}
		if (nRows == 1) {
			return s;
		}
		StringBuilder builder = new StringBuilder();
		int diff = 2 * nRows - 2;
		for (int i = 0; i < nRows; ++i) {
			int index = i;
			while (index < s.length()) {
				builder.append(s.charAt(index));
				index += diff;
				if (i != 0 && i != nRows - 1 && index - 2 * i < s.length()) {
					builder.append(s.charAt(index - 2 * i));
				}
			}
		}
		return builder.toString();
	}
}
