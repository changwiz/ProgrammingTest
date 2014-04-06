package net.wentaochang.FreeFormTest;

import java.util.ArrayList;
import java.util.HashSet;

public class PermutationsII {
	private HashSet<String> map = new HashSet<String>();

	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return result;
		}
		permute(num, 0, num.length, result);
		return result;
	}

	public void permute(int[] num, int k, int n, ArrayList<ArrayList<Integer>> result) {
		if (k == n) {
			String s = "";
			ArrayList<Integer> a = new ArrayList<Integer>();
			for (int i = 0; i < num.length; ++i) {
				a.add(num[i]);
				if (i != num.length - 1) {
					s += num[i] + ",";
				} else {
					s += num[i];
				}
			}
			if (!map.contains(s)) {
				result.add(a);
				map.add(s);
			}
		}
		for (int i = k; i < n; ++i) {
			int temp = num[i];
			num[i] = num[k];
			num[k] = temp;
			permute(num, k + 1, n, result);
		}
	}
}
