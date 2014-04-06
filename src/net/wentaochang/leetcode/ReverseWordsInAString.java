package net.wentaochang.leetcode;

public class ReverseWordsInAString {

	// Boundary conditions : trim(), remove multiple spaces
	public String reverseWords(String s) {
		if (s == null) {
			return null;
		}
		s = s.trim();
		String[] arr = s.split(" ");
		String res = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i].length() > 0) {
				res += arr[i] + " ";
			}
		}
		return res.trim();
	}
}
