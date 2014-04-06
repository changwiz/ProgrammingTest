package net.wentaochang.leetcode;

public class JumpGame {
    public boolean canJump(int[] A) {
        int canReach = 0;
        for(int i=0;i<=A.length-2;++i){
            if(canReach<i){
                return false;
            }
            if(A[i]+i>canReach){
                canReach=A[i]+i;
            }
        }
        if(canReach>=A.length-1){
            return true;
        }else{
            return false;
        }
    }
}
