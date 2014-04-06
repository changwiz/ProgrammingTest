package net.wentaochang.leetcode;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] num) {
		if (num == null || num.length == 0 || num.length == 1) {
			return;
		}
		// step 1, find violation index
		int violationIdx = -1;
		for (int i = num.length - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				violationIdx = i;
				break;
			}
		}

		if (violationIdx == -1) {
			Arrays.sort(num);
			return;
		} else {
			// step 2, swap violation number with change number
			for (int i = num.length - 1; i > violationIdx; i--) {
				if (num[i] > num[violationIdx]) {
					int temp = num[i];
					num[i] = num[violationIdx];
					num[violationIdx] = temp;
					break;
				}
			}

			// step 3, sort from violationIdx + 1
			boolean swapped = true;
			int j = 0;
			int tmp;
			while (swapped) {
				swapped = false;
				j++;
				for (int i = violationIdx + 1; i < num.length - j; i++) {
					if (num[i] > num[i + 1]) {
						tmp = num[i];
						num[i] = num[i + 1];
						num[i + 1] = tmp;
						swapped = true;
					}
				}
			}
			return;
		}

	}
}
