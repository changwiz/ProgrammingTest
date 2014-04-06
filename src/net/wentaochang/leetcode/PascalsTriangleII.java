package net.wentaochang.leetcode;

import java.util.ArrayList;

public class PascalsTriangleII {
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = 0; i <= rowIndex; i++) {
			for (int j = i - 1; j > 0; j--) {
				int val = array.get(j - 1) + array.get(j);
				array.remove(j);
				array.add(j, val);
			}
			array.add(1);
		}
		return array;
	}
}
