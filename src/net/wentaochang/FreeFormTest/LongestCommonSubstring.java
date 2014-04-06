package net.wentaochang.FreeFormTest;

public class LongestCommonSubstring {
	//Find longest common suffix
	public static int longestSubstring(String s, String t) {
		if(s == null || t == null || s.length() ==0 || t.length() == 0){
			return 0;
		}
		int m = s.length();
		int n = t.length();
		int result = 0;
		int [][]table = new int[m+1][n+1];
		for(int i=0;i<=m;++i){
			table[i][0] = 0;
		}
		for(int j=0;j<=n;++j){
			table[0][j] = 0;
		}
		for(int i=1;i<=m;++i){
			for(int j=1;j<=n;++j){
				if(s.charAt(i-1) == t.charAt(j-1)){
					table[i][j] = table[i-1][j-1] + 1;
					result = Math.max(result, table[i][j]);
				} else {
					table[i][j] = 0;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(longestSubstring("abcab", "dca"));
	}
}
