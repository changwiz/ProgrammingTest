package net.wentaochang.FreeFormTest;

public class PalindromePartitioningII {
	public static int minCut(String s) {
		if (s == null || s.length() == 0 || s.length() == 1 || isPalindrome(s)) {
			return 0;
		}
		for (int i = 1; i <= s.length() - 1; ++i) {
			if (bfs(i, s)) {
				return i;
			}
		}
		return 0;
	}

	private static boolean bfs(int cut, String s) {
		if (cut == 0) {
			return isPalindrome(s);
		}
		for (int i = 1; i < s.length(); ++i) {
			if (isPalindrome(s.substring(0, i))) {
				boolean result = bfs(cut - 1, s.substring(i));
				if(result){
					return result;
				}
				
			}
		}
		return false;
	}

	private static boolean isPalindrome(String str) {
		int st = 0;
		int ed = str.length() - 1;
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
	
	public static void main(String[] args){
		minCut("dde");
	}
}
