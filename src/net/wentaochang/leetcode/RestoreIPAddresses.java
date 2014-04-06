package net.wentaochang.leetcode;
import java.util.ArrayList;

public class RestoreIPAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> res = new ArrayList<String>();
		getRes(s, "", res, 4);
		return res;
	}

	private void getRes(String s, String r, ArrayList<String> res, int k) {
		if (k == 0) {
			if (s.length() == 0) {
				res.add(r);
			}
			return;
		} else {
			for (int i = 1; i <= 3; i++) {
				if (s.length() >= i && valid(s.substring(0, i))) {
					if (k == 1) {
						getRes(s.substring(i), r + s.substring(0, i), res, k - 1);
					} else {
						getRes(s.substring(i), r + s.substring(0, i) + ".", res, k - 1);
					}
				}
			}
		}
	}

	private boolean valid(String s) {
		if (s.length() == 3 && (Integer.parseInt(s) > 255 || Integer.parseInt(s) == 0)) {
			return false;
		}
		if (s.length() == 3 && s.charAt(0) == '0') {
			return false;
		}
		if (s.length() == 2 && Integer.parseInt(s) == 0) {
			return false;
		}
		if (s.length() == 2 && s.charAt(0) == '0') {
			return false;
		}
		return true;
	}
}
