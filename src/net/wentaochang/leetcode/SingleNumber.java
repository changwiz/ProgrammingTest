package net.wentaochang.leetcode;

public class SingleNumber {
	//Use XOR: A xor B xor A = B
	public int singleNumber(int[] A) {
		int result = A[0];
		for (int i = 1; i < A.length; ++i) {
			result ^= A[i];
		}
		return result;

	}
}
