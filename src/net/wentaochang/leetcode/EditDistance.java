package net.wentaochang.leetcode;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		int s1 = word1.length();
		int s2 = word2.length();
		if (s1 == 0) {
			return s2;
		}
		if (s2 == 0) {
			return s1;
		}
		int table[][] = new int[s1 + 1][s2 + 1];
		for (int i = 0; i <= s1; i++) {
			table[i][0] = i;
		}
		for (int i = 0; i <= s2; i++) {
			table[0][i] = i;
		}

		for (int i = 1; i <= s1; i++) {
			for (int j = 1; j <= s2; j++) {
				table[i][j] = Math.min(table[i - 1][j] + 1, table[i][j - 1] + 1);
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					table[i][j] = Math.min(table[i - 1][j - 1], table[i][j]);
				} else {
					table[i][j] = Math.min(table[i - 1][j - 1] + 1, table[i][j]);
				}
			}
		}
		return table[s1][s2];
	}
}
