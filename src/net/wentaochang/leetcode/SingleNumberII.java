package net.wentaochang.leetcode;

public class SingleNumberII {
	// General approach of single number I, count '1' for every bit then mod 3
	public int singleNumber(int[] A) {
		int single_number = 0;
		for (int i = 0; i < 32; ++i) {// assume dealing with int32.
			int bit = 0;
			for (int j = 0; j < A.length; ++j) {
				bit = (bit + ((A[j] >> i) & 1)) % 3;
			}
			single_number += (bit << i);
		}
		return single_number;
	}
}
