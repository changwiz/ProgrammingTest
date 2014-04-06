package net.wentaochang.leetcode;

public class RegularExpressionMatching {
	
	// Be careful, not hard but tricky
	//Overall, there are 2 different cases: 1) the second char of pattern is “*” , and 2) the second char of pattern is not “*”.

	//For the 1st case, if the first char of pattern is not “.”, the first char of pattern and string should be the same. Then continue to match the left part.

	//For the 2nd case, if the first char of pattern is “.” or first char of pattern == the first i char of string, continue to match the left.
	public boolean isMatch(String s, String p) {

		if (p.length() == 0)
			return s.length() == 0;

		// p's length 1 is special case
		if(p.length() == 1){
			if(s.length() != 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0))){
				return false;
			} else {
				return true;
			}
		} else if (p.charAt(1) != '*') {
			if (s.length() < 1 || p.charAt(0) != '.' && s.charAt(0) != p.charAt(0))
				return false;
			return isMatch(s.substring(1), p.substring(1));

		} else {
			int len = s.length();

			int i = -1;
			while (i < len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {//pay attention here,compare from back to forward
				if (isMatch(s.substring(i + 1), p.substring(2)))
					return true;
				i++;
			}
			return false;
		}
	}
	
	public static boolean isMatch2(String s, String p) {
		if(s == null && p == null){
		    return true;
		}
		if(s==null&& p!=null || s!=null&&p==null){
		    return false;
		}
		int i=0,j=0;
		while(i<s.length() && j<p.length()){
		    if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
		        i++;
		        j++;
		    } else if(p.charAt(j) == '*'){
		        while(j<p.length()&&p.charAt(j)=='*'){
		            j++;
		        }
		        if(j<p.length()){
		            while(i<s.length()&&s.charAt(i)!=p.charAt(j)){
		            i++;
		           }
		           if(i<s.length()){
		               i++;
		               j++;
		           }
		        }else {
		        	return true;
		        }
		    } else {
		        return false;
		    }
		}
		if(i==s.length()){
		    if(j == p.length()){
		        return true;
		    } else {
		        while(j<p.length()){
		            if(p.charAt(j) != '*'){
		                return false;
		            }
		            j++;
		        }
		        return true;
		    }
		} else {
		    return false;
		}
	}
	
	public static void main(String[] args){
		isMatch2("aa","a*");
	}
}
