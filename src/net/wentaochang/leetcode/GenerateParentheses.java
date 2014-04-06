package net.wentaochang.leetcode;

import java.util.ArrayList;

public class GenerateParentheses {
	//dfs, greedy
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> ans = new ArrayList<String>();
		if (n > 0)
			generator(ans, "", 0, 0, n);
		return ans;
	}

	public void generator(ArrayList<String> ans, String s, int l, int r,
			int n) {
		if (l == n) {
			for (int i = 0; i < n - r; ++i) {
				s += ')';
			}
			ans.add(s);
			return;
		}
		generator(ans, s + '(', l + 1, r, n);
		if (l > r)
			generator(ans, s + ")", l, r + 1, n);
	}
}
