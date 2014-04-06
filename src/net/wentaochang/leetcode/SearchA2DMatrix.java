package net.wentaochang.leetcode;

public class SearchA2DMatrix {
	//boundary case: one element only
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0|| matrix[0].length ==0){
        	return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows * cols - 1;
        while (low <= high) {// use <= instead of <
            int mid = (low + high) / 2;
            if (matrix[mid/cols][mid%cols] == target)
                return true;
            else if (matrix[mid/cols][mid%cols] < target)
                low = mid + 1;
            else if (matrix[mid/cols][mid%cols] > target)
                high = mid - 1;
        }
        return false;        
    }
}
