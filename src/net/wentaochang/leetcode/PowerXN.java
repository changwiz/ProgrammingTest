package net.wentaochang.leetcode;

public class PowerXN {
    public double pow(double x, int n) {
		if(n == -1){
			return 1/x;
		} else if (n == 1) {
			return x;
		} else if (n == 0) {
			return 1;
		} else if (n % 2 == 0) {
			double result = pow(x, n / 2);
			return result * result;
		} else {
			double result = pow(x, (n - 1) / 2);
			return result * result * x;
		} 
    }
}
