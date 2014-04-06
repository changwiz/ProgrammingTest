package net.wentaochang.FreeFormTest;
public class DivideWithoutUsingOperator {
	public static void main(String[] args) {
		System.out.println(divide(25,5));
	}

	public static long divide(int dividend, int divisor) {
		long a = (long) Math.abs((double) dividend);

		long b = (long) Math.abs((double) divisor);

		long ret = 0;
		while (a >= b) {
			long c = b;
			for (int i = 0; a >= c; ++i, c <<= 1) {
				a -= c;
				ret += 1 << i;
			}
		}

		return ((dividend ^ divisor) >> 31 == 1) ? (-ret) : (ret);
	}
}
