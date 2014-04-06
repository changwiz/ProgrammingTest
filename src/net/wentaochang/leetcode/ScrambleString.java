package net.wentaochang.leetcode;

public class ScrambleString {
	//First, check whether string is equal, then whether length is equal, then check whether character occurrence is equal
	//Second, if both's length is 1, return true, else for different i, check substring isScramble recursively
    public static boolean isScramble(String s1, String s2) {
    	if(s1.equals(s2)){
    		return true;
    	}
		if (s1.length() != s2.length())
			return false;
		int[] A = new int[26];
		for(int i = 0;i<26;++i){
			A[i] = 0;
		}
		for (int i = 0; i < s1.length(); i++) {
			A[s1.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s2.length(); i++) {
			A[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (A[i] != 0)
				return false;
		}

		for (int i = 1; i < s1.length(); i++) {
			boolean result = isScramble(s1.substring(0, i), s2.substring(0, i))
					&& isScramble(s1.substring(i, s1.length()),
							s2.substring(i, s2.length()));
			result = result
					|| (isScramble(s1.substring(0, i),
							s2.substring(s2.length() - i, s2.length())) && isScramble(
							s1.substring(i, s1.length()),
							s2.substring(0, s2.length() - i)));
			if (result)
				return true;
		}
		return false; 
    }
    
    public static void main(String[] args){
    	System.out.println(isScramble("abc","bca"));
    }
}
