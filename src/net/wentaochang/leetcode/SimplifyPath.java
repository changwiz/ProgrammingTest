package net.wentaochang.leetcode;
public class SimplifyPath {
	public String simplifyPath(String path) {
		// /, .., . assume the path is valid
		//two boundary cases: /.. and /a///b
		if (path == null || path.length() == 0) {
			return "/";
		}
		String[] strs = path.split("/");
		if (strs.length == 0) {
			return "/";
		}
		String result = "";
		for (int i = 0; i < strs.length; ++i) {
			if (strs[i].length() == 0 || ".".equals(strs[i])) {
				continue;
			} else if ("..".equals(strs[i])) {
				if (result.length() > 0) {
					int j;
					for (j = result.length() - 1; j >= 0; --j) {
						if (result.charAt(j) == '/') {
							break;
						}
					}
					result = result.substring(0, j >= 0 ? j : 0);
				}
			} else {
				result += "/" + strs[i];
			}
		}
		if (result.length() == 0) {
			return "/";
		} else {
			return result;
		}
	}
}
