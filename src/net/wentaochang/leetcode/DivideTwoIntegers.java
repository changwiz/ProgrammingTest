package net.wentaochang.leetcode;

public class DivideTwoIntegers {
	public long divide(long dividend, long divisor) {
		long abs_dividend = Math.abs(dividend);
		long abs_divisor = Math.abs(divisor);

		long ret = 0;
		while (abs_dividend >= abs_divisor) {
			long c = abs_divisor;
			for (int i = 0; abs_dividend >= c; ++i, c <<= 1) {
				abs_dividend -= c;
				ret += 1 << i;
			}
		}

		return (((dividend ^ divisor) >> 31) & 1) != 0 ? (-ret) : (ret);
	}
}
