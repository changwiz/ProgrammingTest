package net.wentaochang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {
	//MUST master, use greedy recursion
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0 || target <= 0) {
			return res;
		}
		Arrays.sort(num);
		ArrayList<Integer> intermediate = new ArrayList<Integer>();
		findSum(num, target, 0, intermediate, res);
		return res;
	}

	private void findSum(int[] num, int target, int index, ArrayList<Integer> intermediate, ArrayList<ArrayList<Integer>> res) {
		if (target == 0) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(intermediate);
			res.add(temp);
			return;
		}
		for (int i = index; i < num.length; ++i) {
			if (num[i] > target) {
				return;
			}
			//Remove duplicates
			if (i > index && num[i] == num[i - 1]) {
				continue;
			}
			intermediate.add(num[i]);
			findSum(num, target - num[i], i + 1, intermediate, res);
			intermediate.remove(intermediate.size() - 1);
		}
	}
}
