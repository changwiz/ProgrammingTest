package net.wentaochang.leetcode;
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (word.length() == 0 || board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (word.charAt(0) == board[i][j]) {
					if (word.length() == 1) {
						return true;
					} else {
						boolean[][] mask = new boolean[board.length][board[0].length];
						mask[i][j] = true;
						if (search(board, i, j, word.substring(1), mask)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private boolean search(char[][] board, int i, int j, String str, boolean[][] mask) {
		if (str.length() == 0) {
			return true;
		} else {
			if ((i > 0) && (board[i - 1][j] == str.charAt(0)) && (mask[i - 1][j] == false)) {
				mask[i - 1][j] = true;
				if (search(board, i - 1, j, str.substring(1), mask)) {
					return true;
				}
				mask[i - 1][j] = false;
			}
			if ((i < board.length - 1) && (board[i + 1][j] == str.charAt(0)) && (mask[i + 1][j] == false)) {
				mask[i + 1][j] = true;
				if (search(board, i + 1, j, str.substring(1), mask)) {
					return true;
				}
				mask[i + 1][j] = false;
			}
			if ((j > 0) && (board[i][j - 1] == str.charAt(0)) && (mask[i][j - 1] == false)) {
				mask[i][j - 1] = true;
				if (search(board, i, j - 1, str.substring(1), mask)) {
					return true;
				}
				mask[i][j - 1] = false;
			}
			if ((j < board[0].length - 1) && (board[i][j + 1] == str.charAt(0)) && (mask[i][j + 1] == false)) {
				mask[i][j + 1] = true;
				if (search(board, i, j + 1, str.substring(1), mask)) {
					return true;
				}
				mask[i][j + 1] = false;
			}
		}
		return false;
	}
}
