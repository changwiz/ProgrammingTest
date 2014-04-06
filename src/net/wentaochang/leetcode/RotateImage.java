package net.wentaochang.leetcode;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        if(matrix == null || matrix[0] == null || matrix[0].length <=1){
            return;
        }
        //rotate odd/even is different
        int size = matrix[0].length-1;
        int offset = matrix[0].length%2 !=0?-1:0;
        int len = (int)Math.floor(((double)size)/2);
        for(int i=0;i<=len;++i){
            for(int j=0;j<=len+offset;++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[size-j][i];
                matrix[size-j][i] = matrix[size-i][size-j];
                matrix[size-i][size-j] = matrix[j][size-i];
                matrix[j][size-i] = temp;
            }
        }
    }
    
    public static void main(String[] args){
    	int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
    	rotate(matrix);
    }
}
