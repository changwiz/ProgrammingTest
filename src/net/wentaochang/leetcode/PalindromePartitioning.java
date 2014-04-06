package net.wentaochang.leetcode;

import java.util.ArrayList;

public class PalindromePartitioning {
	//Recursion
	//To get the all the partitions of a string s:
	//	1. find all the palindromes in substring s[0], and all the palindromes in substring s[1:end]
	//	2. find all the palindromes in substring s[0:1], and all the palindromes in substring s[2:end]
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		ArrayList<String> r = new ArrayList<String>();
		find(s, 0, r, res);
		return res;
	}

	private boolean isPalindrome(String str, int st, int ed) {
		while (st < ed) {
			if (str.charAt(ed) != str.charAt(st)) {
				return false;
			} else {
				st++;
				ed--;
			}
		}
		return true;
	}

	private void find(String s, int st, ArrayList<String> r, ArrayList<ArrayList<String>> res) {
		if (st >= s.length()) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.addAll(r);
			res.add(temp);
		} else {
			for (int i = st; i < s.length(); i++) {
				if (isPalindrome(s, st, i)) {
					r.add(s.substring(st, i + 1));
					find(s, i + 1, r, res);
					r.remove(r.size() - 1);
				}

			}
		}
	}
}
