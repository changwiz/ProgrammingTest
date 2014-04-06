package net.wentaochang.leetcode;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		} else if (s.length() == 0 || s.length() == 1) {
			return true;
		}
		char[] arr = s.toCharArray();
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			if (!isValidChar(arr[i])) {
				i++;
			}
			if (!isValidChar(arr[j])) {
				j--;
			}
			if (i >= j) {
				break;
			}
			if (Character.toLowerCase(arr[i]) != Character.toLowerCase(arr[j])) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
	}

	private static boolean isValidChar(char c) {
		if (c >= '0' && c <= '9') {
			return true;
		} else if (c >= 'a' && c <= 'z') {
			return true;
		} else if (c >= 'A' && c <= 'Z') {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args){
		isPalindrome("......a.....");
	}
}
