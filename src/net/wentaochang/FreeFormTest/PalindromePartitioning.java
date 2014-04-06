package net.wentaochang.FreeFormTest;

import java.util.ArrayList;

public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (s == null || s.length() == 0) {
			return res;
		}
		ArrayList<String> path = new ArrayList<String>();
		dfs(s, path, res);
		return res;
	}

	private void dfs(String s, ArrayList<String> path, ArrayList<ArrayList<String>> res) {
		if (s.length() == 0 || s.length() == 1) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.addAll(path);
			if (s.length() == 1) {
				temp.add(s);
			}
			res.add(temp);
			return;
		}
		for (int i = 1; i <= s.length(); ++i) {
			if (isPalindrome(s.substring(0, i))) {
				path.add(s.substring(0, i));
				dfs(s.substring(i), path, res);
				path.remove(path.size() - 1);
			}
		}

	}

	private boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
