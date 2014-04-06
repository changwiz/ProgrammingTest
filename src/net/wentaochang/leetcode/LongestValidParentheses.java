package net.wentaochang.leetcode;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int longestLength = 0;
		if (s == null || s.length() == 0 || s.length() == 1) {
			return longestLength;
		}
		int last = -1, i = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while (i < s.length()) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (stack.isEmpty()) {
					last = i;
				} else {
					stack.pop();
					if (stack.isEmpty()) {
						longestLength = Math.max(longestLength, i - last);
					} else {
						longestLength = Math.max(longestLength, i - stack.peek());
					}
				}
			}
			i++;

		}
		return longestLength;
	}
}
