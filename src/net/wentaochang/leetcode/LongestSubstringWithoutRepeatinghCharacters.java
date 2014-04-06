package net.wentaochang.leetcode;

public class LongestSubstringWithoutRepeatinghCharacters {
	//Two moving pointer, calculate max at runtime, hashmap to contain repeated character
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0,i=0,j=0;
        if(s == null || s.length() ==0){
            return 0;
        }
        boolean[] map = new boolean[256];
        while(j<s.length()){
            if(map[s.charAt(j)-'a']){
                while(s.charAt(i)!=s.charAt(j)){
                    map[s.charAt(i)-'a'] = false;
                    i++;
                }
                i++;
                j++;
            } else {
                map[s.charAt(j)-'a'] = true;
                j++;
                longestLength = longestLength>j-i?longestLength:j-i;
            }
        }
        
        return longestLength>j-i?longestLength:j-i;
    }
}
