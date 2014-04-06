package net.wentaochang.leetcode;
import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		String result = "";
		if (n <= 0 || k < 1) {
			return result;
		} else if (n == 1) {
			return "1";
		}
		List<Integer> number = new ArrayList<Integer>();
		for (int i = 0; i < n; ++i) {
			number.add(i+1);
		}
		int[] value = new int[n];
		k--;
		for(int i=n-1;i>=0;--i){
			long fac = factorial(i);
			int v = (int) (k/fac);
			k = (int) (k%fac);
			value[i] = v;
		}
		for(int i=n-1;i>=0;--i){
			result += (char)(number.get(value[i]) + '0');
			number.remove(value[i]);
		}
		return result;
	}
	
	public long factorial(int n) {
		long product = 1;
		while(n>0){
			product*=n;
			n--;
		}
		return product;
	}
}
