package net.wentaochang.leetcode;

public class WildCardMatching {
	//Key of this solution is to consider continuous "*"
	
	/*//Time out on leetcode
	public static boolean isMatch(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}
		if (p.charAt(0) == '?') {
			if (s.length() < 1) {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		} else if (p.charAt(0) == '*') {
			int len = s.length();
			int i = -1;
			// find the first non '*' character
			int j = 1;
			while (j < p.length()) {
				if (p.charAt(j) != '*') {
					break;
				}
				j++;
			}
			while (i < len) {
				if (isMatch(s.substring(i + 1), p.substring(j))) {
					return true;
				}
				i++;
			}
			return false;
		} else if (s.length() < 1 || s.charAt(0) != p.charAt(0)) {
			return false;
		} else {
			return isMatch(s.substring(1), p.substring(1));
		}
	}*/

	public static boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int star = -1;
		int ss = i;
		while (i < s.length()) {
			if ((p.charAt(j) == '?') || (p.charAt(j) == s.charAt(i))) {
				i++;
				j++;
				continue;
			}
			if (p.charAt(j) == '*') {
				star = j++;
				ss = i;
				continue;
			}
			if (star >= 0) {
				j = star + 1;
				i = ++ss;
				continue;
			}
			return false;
		}
		while (p.charAt(j) == '*') {
			j++;
		}
		return j >= p.length();
	}
	
	public static void main(String[] args) {
		System.out.println(isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb", "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));
	}
}
