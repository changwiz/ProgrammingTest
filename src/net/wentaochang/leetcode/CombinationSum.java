package net.wentaochang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	// Classic problem, MUST master this solution
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0 || target <= 0) {
			return res;
		}
		Arrays.sort(candidates);
		ArrayList<Integer> intermediate = new ArrayList<Integer>();
		findSum(candidates, target, 0, intermediate, res);
		return res;
	}

	private static void findSum(int[] candidates, int gap, int start, ArrayList<Integer> intermediate, ArrayList<ArrayList<Integer>> res) {
		if (gap == 0) { // 找到一个合法解
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(intermediate);
			res.add(temp);
			return;
		}
		for (int i = start; i < candidates.length; i++) { // 扩展状态
			if (gap < candidates[i]) {
				return; // 剪枝
			}
			//Remove duplicates
			if (i > start && candidates[i] == candidates[i - 1]) {
				continue;
			}
			intermediate.add(candidates[i]); // 执行扩展动作
			findSum(candidates, gap - candidates[i], i, intermediate, res);
			intermediate.remove(intermediate.size() - 1); // 撤销动作
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = combinationSum(new int[] { 1, 1 }, 1);
		for (ArrayList<Integer> t : res) {
			for (Integer i : t) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
