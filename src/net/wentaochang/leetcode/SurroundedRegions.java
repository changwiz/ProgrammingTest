package net.wentaochang.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if(board == null || board.length ==0 || board[0].length == 0) {
        	return;
        }
        int m = board.length;
        int n = board[0].length;
        boolean [][]canFlip = new boolean[m][n];
        Arrays.fill(canFlip, Boolean.TRUE);
        
        for(int i=0;i<m;++i){
        	if(board[i][0] == 'o'){
        		canFlip[i][0] = false;
        	}
        }
        
        for(int i=0;i<n;++i){
        	if(board[0][i] == 'o'){
        		canFlip[0][i] = false;
        	}
        }
        
        for(int i=0;i<m;++i){
        	if(board[i][n-1] == 'o'){
        		canFlip[i][n-1] = false;
        	}
        }
        
        for(int i=0;i<m;++i){
        	if(board[m-1][i] == 'o'){
        		canFlip[m-1][i] = false;
        	}
        }
        
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(canFlip[i][j] && board[i][j] == 'o'){
        			board[i][j] = 'x';
        		}
        	}
        }
    }
    
    class Coordinate {
    	int x;
    	int y;
    	Coordinate(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
		@Override
		public boolean equals(Object obj) {
			if(obj == this){
				return true;
			}
			if(!(obj instanceof Coordinate)){
				return false;
			}
			Coordinate t = (Coordinate)obj;
			return x== t.x && y==t.y;
		}
		
		@Override
		public int hashCode() {
			return 17*x+y;
		}
    }
    
    private void dfs(char[][] board, int i, int j, HashSet<Coordinate> map, boolean [][]canFlip){
    }
}
