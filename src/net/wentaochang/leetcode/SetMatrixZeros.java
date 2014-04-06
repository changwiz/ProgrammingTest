package net.wentaochang.leetcode;

public class SetMatrixZeros {
	//Boundary case: first row ,first column
    public void setZeroes(int[][] matrix) {

		boolean firstRowZero = false;
		boolean firstColZero = false;

		// set the first row and first column to record the rows and cols to be
		// set 0s.

		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] == 0) {

					if (i == 0)

						firstRowZero = true;

					if (j == 0)

						firstColZero = true;

					matrix[0][j] = 0;

					matrix[i][0] = 0;

				}

			}

		}

		// set rows and columns

		for (int i = 1; i < matrix.length; i++) {

			if (matrix[i][0] == 0) {

				for (int j = 1; j < matrix[0].length; j++)

					matrix[i][j] = 0;

			}

		}

		for (int j = 1; j < matrix[0].length; j++) {

			if (matrix[0][j] == 0) {

				for (int i = 1; i < matrix.length; i++)

					matrix[i][j] = 0;

			}

		}

		// set first row and column

		if (firstRowZero) {

			for (int j = 0; j < matrix[0].length; j++)

				matrix[0][j] = 0;

		}

		if (firstColZero) {

			for (int i = 0; i < matrix.length; i++)

				matrix[i][0] = 0;

		}        
    }
}
