package net.wentaochang.leetcode;
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null) {
			return 0;
		}
		/*
		 * String[] strs = s.trim().split(" "); if(strs.length >= 1){ return
		 * strs[strs.length-1].length(); } else { return 0; }
		 */
		int p = s.length() - 1;
		int len = 0;
		boolean trailing = true;
		while (p >= 0) {
			if (s.charAt(p) != ' ') {
				len++;
				trailing = false;
				p--;
			} else if (trailing) {
				p--;
			} else {
				break;
			}
		}
		return len;
	}
	/*
    public int lengthOfLastWord(String s) {
		if(s==null){
			return 0;
		}
		String[] strs = s.trim().split(" ");
		if(strs.length >= 1){
			return strs[strs.length-1].length();
		} else {
			return 0;
		}
    }*/
}
