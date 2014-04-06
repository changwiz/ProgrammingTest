package net.wentaochang.leetcode;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length ==0){
            return 0;
        }
        int emptyStart = -1;
        for(int i=1;i<A.length;++i){
            if(A[i] == A[i-1]){
                if(emptyStart == -1){
                    emptyStart = i;
                }
            } else if(emptyStart!=-1){
                A[emptyStart] = A[i];
                emptyStart++;
            }
        }
        if(emptyStart == -1){
            return A.length;
        } else {
            return emptyStart;
        }
    }
}
