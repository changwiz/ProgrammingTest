package net.wentaochang.careercup;

import java.util.ArrayList;
import java.util.Collections;

public class AllSubsets {
	public static ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (set == null || set.size() == 0) {
			return res;
		}
		Collections.sort(set);
		for (int i = 0; i < set.size(); ++i) {
			int len = res.size();
			for (int j = 0; j < len; ++j) {
				ArrayList<Integer> t = res.get(j);
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.addAll(t);
				temp.add(set.get(i));
				res.add(temp);
			}
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(set.get(i));
			res.add(temp);
		}
		res.add(new ArrayList<Integer>());
		return res;
	}

	public static void main(String[] args) {
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		for (ArrayList<Integer> i : getAllSubsets(set)) {
			System.out.print("[");
			for (Integer p : i) {
				System.out.print(p + " ");
			}
			System.out.print("]");
		}
	}
}
