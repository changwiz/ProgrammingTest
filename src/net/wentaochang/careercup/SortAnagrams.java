package net.wentaochang.careercup;

import java.util.Arrays;
import java.util.Comparator;

public class SortAnagrams {
	public static String[] sortAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return strs;
		}
		Arrays.sort(strs, comparator);
		return strs;
	}

	private static Comparator<String> comparator = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			/*int[] a1 = anagrams(o1);
			int[] a2 = anagrams(o2);
			for (int i = 0; i < a1.length; ++i) {
				if (a1[i] < a2[i]) {
					return -1;
				} else if (a1[i] > a2[i]) {
					return 1;
				}
			}
			return 0;*/
			return sortStr(o1).compareTo(sortStr(o2));
		}

		private int[] anagrams(String o) {
			int[] anagrams = new int[256];
			for (int i = 0; i < o.length(); ++i) {
				anagrams[o.charAt(i) - 'a']++;
			}
			return anagrams;
		}
		
		private String sortStr(String s){
			char[] content = s.toCharArray();
			Arrays.sort(content);
			return new String(content);
		}

	};
	
	public static void main(String[] args) {
		String[] arr = new String[] {"abc","def", "aaa", "edf", "cba", "bca"};
		for(String s: sortAnagrams(arr)){
			System.out.println(s);
		}
		
	}
}
