package net.wentaochang.FreeFormTest;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		Arrays.sort(candidates);
		findSolution(candidates, target, path, res);
		return res;
	}

	private static void findSolution(int[] candidates, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(path);
			res.add(temp);
			return;
		}
		for (int i = 0; i < candidates.length; ++i) {
			path.add(candidates[i]);
			findSolution(Arrays.copyOfRange(candidates, i, candidates.length), target - candidates[i], path, res);
			path.remove(path.size() - 1);
		}

	}

	public static void main(String[] args) {
		int[] cand = { 2, 3, 6, 7 };
		ArrayList<ArrayList<Integer>> res = combinationSum(cand, 7);
		for (ArrayList<Integer> s : res) {
			for (Integer i : s) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
