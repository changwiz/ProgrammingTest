package net.wentaochang.careercup;

import java.util.ArrayList;

public class NQueens {
	// ....Q...
	public static ArrayList<ArrayList<String>> nQueens(int n) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (n <= 0) {
			return res;
		}
		boolean[][] table = new boolean[n][n];
		findSolution(0, table, res);
		return res;
	}

	private static void findSolution(int row, boolean[][] table, ArrayList<ArrayList<String>> res) {
		if (row == table.length) {
			res.add(getSolution(table));
			return;
		}
		for (int i = 0; i < table.length; ++i) {
			if (isValid(table, row, i)) {
				table[row][i] = true;
				findSolution(row + 1, table, res);
				table[row][i] = false;
			}
		}
	}

	private static boolean isValid(boolean[][] table, int row, int column) {
		for (int i = row - 1; i >= 0; --i) {
			if (table[i][column]) {
				return false;
			}
			if (column - row + i >= 0 && table[i][column - row + i]) {
				return false;
			}
			if (column + row - i <= table.length - 1 && table[i][column + row - i]) {
				return false;
			}
		}
		return true;
	}

	private static ArrayList<String> getSolution(boolean[][] table) {
		ArrayList<String> solution = new ArrayList<String>();
		for (int i = 0; i < table.length; ++i) {
			String s = "";
			for (int j = 0; j < table.length; ++j) {
				if (table[i][j]) {
					s += "Q";
				} else {
					s += ".";
				}
			}
			solution.add(s);
		}
		return solution;
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> r = nQueens(4);
		for(ArrayList<String> s: r){
			for(String t:s){
				System.out.println(t);
			}
			System.out.println();
			System.out.println();
		}
	}
}
