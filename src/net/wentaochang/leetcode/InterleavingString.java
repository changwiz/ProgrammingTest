package net.wentaochang.leetcode;

public class InterleavingString {
	//two dimensional DP: hard question, pay attention to index (-1)
	// match condition: Match[i][j]
    //=   (s3.lastChar == s1.lastChar) && Match[i-1][j]
    //	      ||(s3.lastChar == s2.lastChar) && Match[i][j-1]
	public static boolean isInterleave(String s1, String s2, String s3) {
		if(s1 == null || s2 == null || s2 == null) {
			return false;
		}
		if(s1.length()+s2.length() != s3.length()) {
			return false;
		}
		//Initilization
		boolean [][]match = new boolean[s1.length()+1][s2.length()+1];
		match[0][0] = true;
		// i ==0
		for(int j=1;j<=s2.length();++j){
			if(s2.charAt(j-1) == s3.charAt(j-1)) {
				match[0][j] = match[0][j-1];
			} else {
				match[0][j] = false;
			}
		}
		// j ==0
		for(int i=1;i<=s1.length();++i){
			if(s1.charAt(i-1) == s3.charAt(i-1)) {
				match[i][0] = match[i-1][0];
			} else {
				match[i][0] = false;
			}
		}
		for(int i=1;i<=s1.length();++i){
			for(int j=1;j<=s2.length();++j){ // use or because for strings a,aba, aaba, you can use either one as candidates 
				if(s1.charAt(i-1) == s3.charAt(i+j-1)){
					match[i][j] |= match[i-1][j];
				} 
				if(s2.charAt(j-1) == s3.charAt(i+j-1)){
					match[i][j] |= match[i][j-1];
				}
			}
		}
		return match[s1.length()][s2.length()];
	}
	
	
	public static void main(String[] args) {
		isInterleave("aabc","abad", "aabadabc");
	}
}
