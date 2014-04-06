package net.wentaochang.leetcode;

public class CountAndSay {
    public static String countAndSay(int n) {
    	String res = "1";
        while(n>1){
        	res = getNext(res);
        	n--;
        }
        return res;
    }
    
	public static String getNext(String s) {
		String res = "";
		int count = 0;
		char[] array = s.toCharArray();
		char str = 0;
		for (int i = 0; i < array.length; ++i) {
			if (i == 0) {
				str = array[i];
				count = 1;
			} else if (array[i] == array[i - 1]) {
				count++;
			} else {
				res += (char) ('0' + count);
				res += str;
				str = array[i];
				count = 1;
			}
		}
		res += (char) ('0' + count);
		res += str;
		return res;
	}
	
	public static void main(String[] args){
		System.out.println(countAndSay(5));
	}
}
