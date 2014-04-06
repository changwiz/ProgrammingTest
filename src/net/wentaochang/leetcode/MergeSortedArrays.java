package net.wentaochang.leetcode;

public class MergeSortedArrays {
    public void merge(int A[], int m, int B[], int n) {
        while(m>=1&&n>=1){
            if(A[m-1]>=B[n-1]){
                A[m+n-1] = A[m-1];
                m--;
            } else {
                A[m+n-1] = B[n-1];
                n--;
            }
        }
        if(m<=0){
            while(n>=1){
                A[n-1] = B[n-1];
                n--;
            }
        }
    }
}
