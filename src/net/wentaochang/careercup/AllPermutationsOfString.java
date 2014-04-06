package net.wentaochang.careercup;

import java.util.ArrayList;
import java.util.Arrays;

public class AllPermutationsOfString {
	public static ArrayList<String> getAllPermutations(String s) {
		ArrayList<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			return res;
		} else if (s.length() == 1) {
			res.add(s);
			return res;
		}
		boolean[] visited = new boolean[s.length()];
		ArrayList<Character> string = new ArrayList<Character>();
		char[] str = s.toCharArray();
		Arrays.sort(str);
		findAllPermutation(str, string, visited, res);
		return res;
	}

	private static void findAllPermutation(char[] str, ArrayList<Character> string, boolean[] visited, ArrayList<String> res) {
		boolean has = false;
		for (int i = 0; i < visited.length; ++i) {
			if (visited[i] == false) {
				visited[i] = true;
				string.add(str[i]);
				findAllPermutation(str, string, visited, res);
				visited[i] = false;
				string.remove(string.size() - 1);
				has = true;
			}
		}
		if (!has) {
			String s = "";
			for (Character c : string) {
				s += c;
			}
			res.add(s);
			return;
		}

	}

	public static void main(String[] args) {
		for (String s : getAllPermutations("aac")) {
			System.out.println(s);
		}
	}
}
