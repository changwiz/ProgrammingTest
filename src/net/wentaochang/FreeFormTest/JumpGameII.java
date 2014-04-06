package net.wentaochang.FreeFormTest;

public class JumpGameII {
	public static int jump(int[] A) {
		int minSteps = 0;
		if (A == null || A.length == 0 || A.length == 1) {
			return minSteps;
		}
		int last = 0;
		int next = A[0];
		for (int i = 0; i < A.length && last < A.length; ++i) {
			if (i > last) {
				if(next<=last){
					return -1;
				}
				minSteps++;
				last = next;
			}
			next = Math.max(next, i + A[i]);
		}
		return minSteps;
	}
	
	public static void main(String[] args){
		int[] A= {2,3,1,1,1,1,4};
		System.out.println(jump(A));
	}
}
