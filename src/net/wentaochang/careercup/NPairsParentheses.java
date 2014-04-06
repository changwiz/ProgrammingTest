package net.wentaochang.careercup;

import java.util.ArrayList;

public class NPairsParentheses {
	private static String s = "";

	public static ArrayList<String> getAllPairsParentheses(int count) {
		ArrayList<String> res = new ArrayList<String>();
		if (count <= 0) {
			return res;
		}
		findAllPairs(0, 0, count, res);
		return res;
	}

	private static void findAllPairs(int left, int right, int count, ArrayList<String> res) {
		if (left == right && left == count) {
			res.add(s);
			return;
		}
		if (left < count) {
			s += "(";
			findAllPairs(left + 1, right, count, res);
			s = s.substring(0, s.length() - 1);
		}
		if (right < count && right < left) {
			s += ")";
			findAllPairs(left, right + 1, count, res);
			s = s.substring(0, s.length() - 1);
		}

	}

	public static void main(String[] args) {
		for (String s : getAllPairsParentheses(4)) {
			System.out.println(s);
		}
	}
}
