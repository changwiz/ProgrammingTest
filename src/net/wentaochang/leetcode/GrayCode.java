package net.wentaochang.leetcode;

import java.util.ArrayList;

public class GrayCode {
	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(n<=0){
		    return res;
		}
		res.add(0);
		res.add(1);
		for (int i = 2; i <= n; ++i) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			int offset = (int) Math.pow(2, i-1);  //Pay attention here, power of 2, not 10
			for (int j = res.size() - 1; j >= 0; j--) {
				temp.add(offset + res.get(j));
			}
			res.addAll(temp);
		}
		return res;
	}
}
