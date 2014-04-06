package net.wentaochang.leetcode;
import java.util.ArrayList;

public class TestJustification {
	public static ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<String>();
		if (words == null || words.length == 0 || L <= 0) {
			result.add("");
			return result;
		}
		String currentStr = null;
		for (int i = 0; i < words.length; ++i) {
			if (currentStr != null && currentStr.length() + words[i].length() + 1 > L) {
				addStr(currentStr, L, result);
				currentStr = words[i];
			} else {
				if (currentStr == null) {
					currentStr = words[i];
				} else {
					currentStr += " " + words[i];
				}
			}
		}
		if (currentStr != null) {
			int length = currentStr.length();
			for (int j = 0; j < L - length; ++j) {
				currentStr += " ";
			}
			result.add(currentStr);
		}
		return result;
	}

	public static void addStr(String currentStr, int L, ArrayList<String> result) {
		String[] strs = currentStr.split(" ");
		String current = "";
		if (strs.length == 1) {
			current += currentStr;
			for (int j = 0; j < L - currentStr.length(); ++j) {
				current += " ";
			}
		} else {
			int numOfSpace = strs.length - 1 + L - currentStr.length();
			int space = numOfSpace / (strs.length - 1);
			int overflow = numOfSpace % (strs.length - 1);
			for (String s : strs) {
				current += s;
				if (numOfSpace > 0) {
					for (int j = 0; j < space; ++j) {
						current += " ";
						numOfSpace--;
					}
					if (overflow > 0) {
						current += " ";
						overflow--;
						numOfSpace--;
					}
				}
			}
		}
		result.add(current);
	}

	public static void main(String[] args) {
		System.out.println(fullJustify(new String[] { "" }, 2));
	}
}
