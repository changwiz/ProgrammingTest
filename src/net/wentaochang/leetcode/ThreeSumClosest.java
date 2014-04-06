package net.wentaochang.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		if (num.length < 3) { // if less than three items then return 0
			return Integer.MAX_VALUE;
		}
		Arrays.sort(num);
		int res = num[0] + num[1] + num[2];
		for (int i = 0; i < num.length - 2; ++i) {
			if (i > 0 && num[i] == num[i - 1])
				continue;
			int start = i + 1, end = num.length - 1;
			while (start < end) {
				int sum = num[i] + num[start] + num[end];
				if (Math.abs(sum - target) < Math.abs(res - target)) {
					res = sum;
				}
				if (sum == target) {
					return res;
				} else if (sum < target) {
					start++;
				} else {
					end--;
				}
			}// end-while
		}
		return res;
	}
}
