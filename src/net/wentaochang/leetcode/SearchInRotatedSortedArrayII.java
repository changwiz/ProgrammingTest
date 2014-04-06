package net.wentaochang.leetcode;
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if(A==null||A.length==0){
            return false;
        }
        return search(A,0,A.length-1,target);
    }
    
    private boolean search(int[] A, int low, int high, int target){
        if(low>high){
            return false;
        }
        int mid = low + (high-low)/2;
        if(target == A[mid]){
            return true;
        } else if(A[low]<A[mid]){
            if(A[low]<=target && target<A[mid]){
                return search(A, low, mid-1, target);
            } else {
                return search(A,mid+1,high,target);
            }
            
        } else if(A[low] == A[mid]){ // If there's duplicate, A[low]=A[mid]=>search(low+1,high)
            return search(A,low+1,high,target);
        }else {
            if(A[mid]<target && target<=A[high]){
                return search(A, mid+1, high, target);
            } else {
                return search(A,low,mid-1,target);
            }            
        }
    }
}
