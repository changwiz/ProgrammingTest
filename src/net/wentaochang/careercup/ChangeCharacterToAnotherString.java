package net.wentaochang.careercup;

import java.util.ArrayList;

public class ChangeCharacterToAnotherString {
	// Dictionary needs to be cleared
	public static ArrayList<ArrayList<String>> getAllPaths(String a, String b, ArrayList<String> dictionary) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		ArrayList<String> path = new ArrayList<String>();
		if (a == null || b == null || dictionary == null) {
			return res;
		}
		if (a.length() != b.length() || dictionary.size() == 0) {
			return res;
		}
		getAllPaths(a, b, dictionary, res, path);
		return res;
	}

	private static void getAllPaths(String a, String b, ArrayList<String> dictionary, ArrayList<ArrayList<String>> res, ArrayList<String> path) {
		if (a.equals(b)) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.addAll(path);
			res.add(temp);
			return;
		}
		if (dictionary.size() > 0) {
			for (int i = 'a'; i <= 'z'; ++i) {
				for (int j = 0; j <= a.length() - 1; ++j) {
					String t = a.substring(0, j) + (char) i + ((j + 1 <= a.length()) ? a.substring(j + 1) : "");
					if (isValid(t, dictionary)) {
						path.add(t);
						dictionary.remove(t);
						getAllPaths(t, b, dictionary, res, path);
						path.remove(path.size() - 1);
						dictionary.add(t);
					}
				}
			}
		}

	}

	private static boolean isValid(String a, ArrayList<String> dictionary) {
		for (String s : dictionary) {
			if (s.equals(a)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String a = "damp";
		String b = "like";
		ArrayList<String> dictionary = new ArrayList<String>();
		dictionary.add("lamp");
		dictionary.add("limp");
		dictionary.add("lime");
		dictionary.add("like");
		ArrayList<ArrayList<String>> res = getAllPaths(a, b, dictionary);
		for (ArrayList<String> t : res) {
			for (String s : t) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
}
