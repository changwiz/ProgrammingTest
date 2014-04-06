package net.wentaochang.leetcode;

public class JumpGameII {
	public int jump(int[] A) {
		int minStep = 0;
		if(A==null||A.length ==0||A.length == 1){
			return minStep;
		}
		int last = 0;
		int next = A[0];
		for(int i=1;i<A.length;++i){
			if(i>last){
				if(next<i)return -1;
				last = next;
				minStep++;
			}
			next = Math.max(next, i+A[i]);
		}
		
		return minStep; 
	}
}
