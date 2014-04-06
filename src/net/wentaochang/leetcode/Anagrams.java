package net.wentaochang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		if (strs == null || strs.length == 0) {
			return result;
		}
		Map<String, String> map = new HashMap<String, String>();
		for (String s : strs) {
			int[] table = new int[26];
			for (int i = 0; i < s.length(); ++i) {
				char c = s.charAt(i);
				table[c - 'a']++;
			}
			String key = Arrays.toString(table);
			if (map.get(key) != null) {
				if (!result.contains(map.get(key))) {
					result.add(map.get(key));
				}
				result.add(s);
			} else {
				map.put(key, s);
			}
		}
		return result;
    }
}
