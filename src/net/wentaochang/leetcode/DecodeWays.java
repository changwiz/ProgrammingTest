package net.wentaochang.leetcode;
public class DecodeWays {
	//Recursive
	/*public int numDecodings(String s) {
		if (s != null && s.length() > 0) {
			return count(s, s.length() - 1);
		}
		return 0;
	}

	private int count(String s, int index) {
		if (index == 0) {
			return checkOne(s, 0) ? 1 : 0;
		} else if (index == 1) {
			if (checkTwo(s, 1)) {
				return checkOne(s, 0) ? 1 : 0 + 1;
			} else {
				return checkOne(s, 0) ? 1 : 0;
			}
		}
		int count = 0;
		if (checkOne(s, index)) {
			count += count(s, index - 1);
		}
		if (checkTwo(s, index)) {
			count += count(s, index - 2);
		}
		return count;
	}*/

	//DP
    /*public int numDecodings(String s) { 
        if(s==null||s.length()==0){
            return 0;
        }
        if(s.length()==1){
            if(s.charAt(0)=='0'){
                return 0;
            } else {
                return 1;
            }
        }
        int[] table = new int[s.length()+1];
        if(s.charAt(0)=='0'){
            return 0;
        }
        table[0] = 1;
        table[1] = 1;
        
        for(int i=2;i<=s.length();++i){
            char c1 = s.charAt(i-1);
            char c2 = s.charAt(i-2);
            if(c1 == '0'){
                if(c2!='1' && c2!='2'){
                    return 0;
                } else {
                    table[i] = table[i-2];
                }
            } else if(c2 == '2'&& c1>='0' && c1<='6' || c2 == '1'){
                table[i] = table[i-1] + table[i-2];
            } else {
                table[i] = table[i-1];
            }
        }
        return table[s.length()];
    }*/
	private boolean checkOne(String s, int pos) {
		if (s.charAt(pos) != '0') {
			return true;
		}
		return false;
	}

	private boolean checkTwo(String s, int pos) {
		if (s.charAt(pos - 1) == '1' || (s.charAt(pos - 1) == '2' && s.charAt(pos) <= '6')) {
			return true;
		}
		return false;
	}
	
	//iterative
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int f2 = checkOne(s, 0) ? 1 : 0;
		int f1 = 0, f = 0;
		if(s.length() >=2){
			if(checkOne(s,1)){
				f1 += f2;
			}
			if(checkTwo(s, 1)){
				f1 += 1;
			}
		}
		if (s.length() == 1) {
			return f2;
		} else if (s.length() == 2) {
			return f1;
		}
		for (int i = 2; i < s.length(); ++i) {
			if (checkOne(s, i)) {
				f += f1;
			}
			if (checkTwo(s, i)) {
				f += f2;
			}
			f2 = f1;
			f1 = f;
			f = 0;
		}
		return f1; //æ³¨æ„�return f1
	}
}
