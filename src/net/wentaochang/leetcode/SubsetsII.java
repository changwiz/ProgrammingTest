package net.wentaochang.leetcode;
import java.util.ArrayList;
import java.util.Arrays;


public class SubsetsII {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		if (num == null)
			return null;

		Arrays.sort(num);

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
		//when meet the same element as previous one, then generate new subsets ONLY from 
		//the subsets generated from previous iteration, other than the whole subsets list.
		for (int i = 0; i < num.length; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

			if(i != 0 && num[i] == num[i-1]) {
				// get sets that are in prev set
				for (ArrayList<Integer> a : prev) {
					temp.add(new ArrayList<Integer>(a));
				}
			} else {
				// get sets that are already in result
				for (ArrayList<Integer> a : result) {
					temp.add(new ArrayList<Integer>(a));
				}
			}

			// add S[i] to existing sets
			for (ArrayList<Integer> a : temp) {
				a.add(num[i]);
			}

			if(i == 0 || num[i] != num[i-1]) {
				// add S[i] only as a set
				ArrayList<Integer> single = new ArrayList<Integer>();
				single.add(num[i]);
				temp.add(single);
			}
			
			prev = temp;
			result.addAll(temp);
		}

		// add empty set
		result.add(new ArrayList<Integer>());

		return result;
	}
}
