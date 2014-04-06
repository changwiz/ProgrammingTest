package net.wentaochang.leetcode;

public class LongestPalindromicSubstring {
	//Pay attention, there're even and odd palindrome
	public String longestPalindrome(String s) {
		if (s == null || s == "") {
			return "";
		}
		String max = s.substring(0, 1);
		for (int i = 0; i < s.length() - 1; ++i) {
			String t = expandFromCenter(s, i, i);
			if (t.length() > max.length()) {
				max = t;
			}
			String v = expandFromCenter(s, i, i + 1);
			if (v.length() > max.length()) {
				max = v;
			}
		}
		return max;
	}

	public String expandFromCenter(String s, int l, int r) {
		int length = s.length();
		while (l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return s.substring(l + 1, r);
	}
}
