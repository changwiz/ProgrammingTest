package net.wentaochang.leetcode;

import java.util.ArrayList;

public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int m = triangle.size();
        int table[][] = new int[m][m];
        table[0][0] = triangle.get(0).get(0);
        for(int i=1;i<m;++i){
            for(int j=0;j<=i;++j){
                if(j==0){
                  table[i][j] = table[i-1][j]; 
                } else if(j==i){
                    table[i][j] = table[i-1][j-1];
                } else {
                    table[i][j] = Math.min(table[i-1][j-1], table[i-1][j]);
                }
                table[i][j] += triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<m;++j){
            if(table[m-1][j] <min){
                min = table[m-1][j];
            }
        }
        return min;
    }
}
