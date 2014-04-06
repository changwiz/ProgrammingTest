package net.wentaochang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubstringWithConcatenationofAllWords {
	// need array, match array, while loop
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || L == null || L.length == 0) {
			return result;
		}
		int m = S.length(), n = L.length, size = L[0].length();
		//use need[] to deal with duplicate
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int[] need = new int[n];
		for (int i = 0; i < n; ++i) {
			if (!map.containsKey(L[i])) {
				map.put(L[i], i);
			}
			need[map.get(L[i])]++;
		}
		int[] v = new int[m];
		Arrays.fill(v, -1);
		for (int i = 0; i < m - size + 1; i++) {
			String test = S.substring(i, i + size);
			if (map.get(test) != null) {
				v[i] = map.get(test);
			} else {
				v[i] = -1;
			}
		}
		for (int j = 0; j < size; j++) {
			int[] find = new int[n];
			int count = 0;
			int beginIndex = j;
			for (int i = j; i < m - size + 1; i += size) {
				if (v[i] == -1) {
					count = 0;
					beginIndex = i + size;
					Arrays.fill(find, 0);
				} else {
					int id = v[i];
					find[id]++;
					if (need[id] > 0 && find[id] <= need[id]) {
						count++;
					}
					if (count == n) {
						result.add(beginIndex);
					}
					// move current window one size forward
					if ((i - beginIndex) / size + 1 == n) {
						id = v[beginIndex];
						if (need[id] > 0 && find[id] == need[id]) {
							count--;
						}

						find[id]--;
						beginIndex += size;
					}
				}
			}
		}
		return result;
	}
}
