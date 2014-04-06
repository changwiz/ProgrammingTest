package net.wentaochang.leetcode;


public class DistinctSubsequences {
	//This has a DP solution
	/*private int count = 0;

	public int numDistinct(String S, String T) {
		if(S == null || T==null || S.length() < T.length()){
			return -1;
		}
		match(S, T);
		return count;
	}

	private void match(String s, String t) {
		if (t.length() == 0) {
			count++;
			return;
		} else if (s.length() == 0) {
			return;
		}

		for (int i = 0; i < s.length(); ++i) {
			if (t.charAt(0) == s.charAt(i)) {
				match(s.substring(i + 1, s.length()), t.substring(1, t.length()));
			}
		}
	}*/
	
	public int numDistinct(String S, String T) {
		if (S == null || T == null || S.length() == 0 || T.length() == 0 || S.length() < T.length()) {
			return 0;
		}

		int[][] table = new int[S.length() + 1][T.length() + 1];
		for (int i = 0; i <= S.length(); ++i) {
			table[i][0] = 1;
		}
		for (int i = 1; i <= S.length(); ++i) {
			for (int j = 1; j <= T.length(); ++j) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					table[i][j] = table[i - 1][j] + table[i - 1][j - 1];
				} else {
					table[i][j] = table[i - 1][j];
				}
			}
		}

		return table[S.length()][T.length()];
	}
}
