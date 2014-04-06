package net.wentaochang.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	//Recursive solution
	/*
	public static boolean wordBreak(String s, Set<String> dict) {
		if (s == null || dict == null || dict.size() == 0) {
			return false;
		}
		if (s.length() == 0) {
			return true;
		} else {
			boolean result = false;
			for (int i = 0; i < s.length(); ++i) {
				if (dict.contains(s.substring(0, i+1))) {
					result = wordBreak(s.substring(i+1), dict);
				}
				if (result) {
					return true;
				}
			}
			return false;
		}
	}*/
	
	//DP solution j>i, t[j] = true if t[i]==true and s[j-i] is in dictionary
	// this solution is very delicate
    public static boolean wordBreak(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state
 
        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i]) 
                continue;
 
            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;
 
                if(t[end]) continue;
 
                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }
 
        return t[s.length()];
    }
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>(Arrays.asList("abbcbda", "cbdaaa", "b", "dadaaad", "dccbbbc", "dccadd", "ccbdbc", "bbca", "bacbcdd", "a", "bacb",
				"cbc", "adc", "c", "cbdbcad", "cdbab", "db", "abbcdbd", "bcb", "bbdab", "aa", "bcadb", "bacbcb", "ca", "dbdabdb", "ccd", "acbb", "bdc",
				"acbccd", "d", "cccdcda", "dcbd", "cbccacd", "ac", "cca", "aaddc", "dccac", "ccdc", "bbbbcda", "ba", "adbcadb", "dca", "abd", "bdbb",
				"ddadbad", "badb", "ab", "aaaaa", "acba", "abbb"));
		System.out.println(wordBreak("acaaaaabbbdbcccdcdaadcdccacbcccabbbbcdaaaaaadb", set));
		//System.out.println(wordBreak("ac", set));
	}
}
