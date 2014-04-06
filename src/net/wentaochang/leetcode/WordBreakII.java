package net.wentaochang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakII {
	//Timeout for recursion
	/*public static ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
			return res;
		}
		findSentence(s, "", dict, res);
		return res;
	}

	private static void findSentence(String s, String c, Set<String> dict, ArrayList<String> res) {
		if (s.length() == 0) {
			res.add(c.trim());
		} else {
			for (int i = 0; i < s.length(); ++i) {
				if (dict.contains(s.substring(0, i + 1))) {
					findSentence(s.substring(i + 1), c + " " + s.substring(0, i + 1), dict, res);
				}
			}
		}
	}*/
	
	//Hard problem
	//在DP的时候记录前驱节点的值到数组，然后DFS该数组构造结果
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean f[] = new boolean[len + 1];
        ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= len; i++) {
            prev.add(new ArrayList<Integer>());
        }
        f[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    prev.get(i).add(j);
                    f[i] = true;
                }
            }
        }
        ArrayList<String> result = new ArrayList<String>();
        buildResult(s, prev, len, result, "");
        return result;
    }
    
	//build output string reversely
    private static void buildResult(String s, ArrayList<ArrayList<Integer>> prev, int end, ArrayList<String> result, String current) {
        ArrayList<Integer> prevs = prev.get(end);
        for (int i = 0; i < prevs.size(); i++) {
            int n = prevs.get(i);
            String sub = s.substring(n, end);
            String r = sub;
            if (!current.equals("")) {
                r = r + " " + current;
            }
            if (n == 0) {
                result.add(r);
            }
            else {
                buildResult(s, prev, n, result, r);
            }
        }
    }
    
	public static void main(String[] args){
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		Set<String> dict = new HashSet<String>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
		for(String i:wordBreak(s,dict)){
			System.out.println(i);
		}
	}
}
