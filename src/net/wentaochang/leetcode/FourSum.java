package net.wentaochang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FourSum {
	//Attention: how to guarantee quadruple unique -- use a string map
	   public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			if (num == null || num.length < 4) {
				return result;
			}
			
			HashMap<String,Boolean> map = new HashMap<String,Boolean>();
			Arrays.sort(num);
			for (int i = 0; i < num.length - 3; ++i) {
				if (num[i] >= target && num[i] > 0) {
					break;
				}
				for (int j = i + 1; j < num.length - 2; ++j) {
					if (num[i] + num[j] >= target && num[j] > 0) {
						break;
					}
					int currentVal = num[i] + num[j];
					int k = j + 1, l = num.length - 1;
					while (k < l) {
						if (currentVal + num[k] + num[l] < target) {
							k++;
						} else if (currentVal + num[k] + num[l] > target) {
							l--;
						} else if (currentVal + num[k] + num[l] == target) {
							ArrayList<Integer> item = new ArrayList<Integer>();
							item.add(num[i]);
							item.add(num[j]);
							item.add(num[k]);
							item.add(num[l]);
							String s = num[i]+" "+num[j]+" "+num[k]+ " "+num[l];
							if(map.get(s) != Boolean.TRUE){
							    map.put(s,true);
							    result.add(item);
							}
							k++;
							l--;
						}
					}
				}
			}
			return result;
	    }
}
