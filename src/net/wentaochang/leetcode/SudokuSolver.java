package net.wentaochang.leetcode;

import java.util.Stack;

public class SudokuSolver {
	boolean [][]rows = new boolean[9][9];
	boolean [][]cols = new boolean[9][9];
	boolean [][]blocks = new boolean[9][9];
	public void solveSudoku(char[][] board) {
		Stack<Record> stack = new Stack<Record>();
		for(int i=0;i<9;++i){
			for(int j=0;j<9;++j){
				if(board[i][j] != '.') {
					int c = board[i][j] - '1';
					rows[i][c] = cols[j][c] = blocks[3*(i/3)+j/3][c] = true;
				}
			}
		}
		int i = 0, j=0, c = 0;
		while(i<=8){
			if(board[i][j] != '.') {
				if(j==8) {
					i++;
					j=0;
				} else {
					j++;
				}
				c = 0;
				continue;
			}
			if(isValid(i,j,c)){
				board[i][j] = (char) (c + '1');
				stack.push(new Record(i,j,c));
				if(j==8) {
					i++;
					j=0;
				} else {
					j++;
				}
				c = 0;
			} else if(c != 8){
				c++;
			} else {
				do {
					if (stack.isEmpty()) {
						return;
					}
					Record r = stack.pop();
					i = r.i;
					j = r.j;
					board[i][j] = '.';
					rows[i][r.c] = cols[j][r.c] = blocks[3 * (i / 3) + j / 3][r.c] = false;
					c = r.c + 1;
				} while (c > 8);
			}
		}
	}
	
	public boolean isValid(int i, int j, int c) {
		if(rows[i][c] || cols[j][c] || blocks[3*(i/3)+j/3][c]) {
			return false;
		} else {
			rows[i][c] = cols[j][c] = blocks[3*(i/3)+j/3][c] = true;
			return true;
		}
	}
	
	private static class Record {
		int i;
		int j;
		int c;
		
		Record(int i, int j, int c){
			this.i = i;
			this.j = j;
			this.c = c;
		}
	}
}
