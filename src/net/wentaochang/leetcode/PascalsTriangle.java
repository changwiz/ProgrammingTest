package net.wentaochang.leetcode;

import java.util.ArrayList;

public class PascalsTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		if (numRows < 1) {
			return res;
		}
		path.add(1);
		res.add(path);
		for (int i = 1; i < numRows; ++i) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j <= i; ++j) {
				if (j == 0) {
					temp.add(path.get(j));
				} else if (j == i) {
					temp.add(path.get(j - 1));
				} else {
					temp.add(path.get(j - 1) + path.get(j));
				}
			}
			res.add(temp);
			path = temp;
		}
		return res;
	}
}
