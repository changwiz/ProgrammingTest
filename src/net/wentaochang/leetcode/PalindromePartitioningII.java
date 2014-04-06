package net.wentaochang.leetcode;

public class PalindromePartitioningII {
	//hard problem
	//最优解，使用DP，这题2个dp P[i][j] = true if s[i] == s[j] && P[i+1][j-1], 上半扇，因为i永远小于等于j
	//D[i] min number of cut in [i,n]
	public int minCut(String s) {
		int len = s.length();
		int[] D = new int[len + 1];
		boolean[][] P = new boolean[len][len];
		// the worst case is cutting by each char
		for (int i = 0; i <= len; i++) {
			D[i] = len - i;
		}
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				P[i][j] = false;
			}
		}
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || P[i + 1][j - 1])) {
					P[i][j] = true;
					D[i] = Math.min(D[i], D[j + 1] + 1);
				}
			}
		}
		return D[0] - 1;
	}
}
