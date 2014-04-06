package net.wentaochang.careercup;

public class CountNumberOf2InN {
	public static int numberOf2(int n) {
		// two cases: (1) f(513)= 5*f(99)+f(13)+ 100
		// (2) f(252) = 2*f(99) + f(52) + 52 + 1;
		if (n <= 0) {
			return 0;
		}
		int power = 1;
		while (Math.pow(10, power) < n) {
			power++;
		}
		int t = (int) Math.pow(10, power - 1);
		int nFirst = n / t;
		int nSecond = n % t;

		int nFirstPart = 0;
		if (nFirst > 2) {
			nFirstPart += t;
		} else if (nFirst == 2) {
			nFirstPart += nSecond + 1;
		}

		int nSecondPart = nFirst * numberOf2(t - 1) + numberOf2(nSecond);

		return nFirstPart + nSecondPart;
	}
	
	public static void main(String[] args) {
		System.out.println(numberOf2(279));
	}
}
