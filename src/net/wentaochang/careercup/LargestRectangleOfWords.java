package net.wentaochang.careercup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class LargestRectangleOfWords {
	// HARD questions, grouping first, then iterate from max*max to 1, then dfs
	public static ArrayList<String> getLargestRec(String[] dictionary) {

		HashMap<Integer, ArrayList<String>> map = grouping(dictionary);
		ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());
		Collections.sort(keys);
		int largestLength = keys.get(keys.size() - 1);
		int largestRec = largestLength * largestLength;
		for (int z = largestRec; z > 0; z--) {
			for (int i = 1; i <= z; i++) {
				if (z % i == 0) {
					int j = z / i;
					if (j <= largestLength) {
						if (map.get(i) != null && map.get(j) != null) {
							ArrayList<String> rectangle = makeRectangle(i, map.get(i), j, map.get(j));
							if (rectangle != null) {
								return rectangle;
							}
						}
					}
				}
			}
		}
		return null;
	}

	private static ArrayList<String> makeRectangle(int rows, ArrayList<String> rowVal, int columns, ArrayList<String> colVal) {
		ArrayList<String> res = new ArrayList<String>();
		return makePartialRectangle(0, columns, rowVal, colVal, res);
	}

	private static ArrayList<String> makePartialRectangle(int index, int count, ArrayList<String> values, ArrayList<String> dictionary, ArrayList<String> res) {
		if (index >= count) {
			if (isInDictionary(dictionary, res)) {
				return res;
			} else {
				return null;
			}
		}
		for (int i = 0; i < count; ++i) {
			if(values.isEmpty()) {
				return null;
			}
			String s = values.get(0);
			values.remove(0);
			res.add(s);
			ArrayList<String> ret = makePartialRectangle(index + 1, count, values, dictionary, res);
			if (ret != null) {
				return ret;
			}
			res.remove(res.size() - 1);
			values.add(0, s);
		}
		return null;
	}

	private static boolean isInDictionary(ArrayList<String> dictionary, ArrayList<String> res) {
		int row = res.size();
		int col = res.get(0).length();
		String[] strs = new String[col];
		for(int i=0;i<col;++i){
			strs[i] = "";
		}
		for(int j=0;j<row;++j){
			for(int i=0;i<col;++i){
				strs[i] += res.get(j).charAt(i);
			}
		}
		boolean flag = false;
		for(String s:strs){
			for(String t:dictionary){
				flag = false;
				if(s.equalsIgnoreCase(t)){
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	private static HashMap<Integer, ArrayList<String>> grouping(String[] dictionary) {
		Arrays.sort(dictionary, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				if (arg0.length() > arg1.length()) {
					return 1;
				} else if (arg0.length() == arg1.length()) {
					return 0;
				} else {
					return -1;
				}
			}

		});
		HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
		for (String s : dictionary) {
			int len = s.length();
			ArrayList<String> temp = map.get(len);
			if (temp == null) {
				temp = new ArrayList<String>();
				map.put(len, temp);
			}
			temp.add(s);
		}
		return map;
	}

	public static void main(String[] args) {
		String[] dic = { "abcd", "befa", "cuva", "duva", "beuv", "cfvv", "daaa", "af", "ce" };
		ArrayList<String> res = getLargestRec(dic);
		if(res != null){
			for (String s : res) {
				System.out.println(s);
			}
		}
	}
}
