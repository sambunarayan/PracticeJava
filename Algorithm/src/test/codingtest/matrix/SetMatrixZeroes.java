package test.codingtest.matrix;

public class SetMatrixZeroes {
	
	// *****
	// leetcode.73 Set Matrix Zeroes

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void setZeroes(int[][] matrix) {
		int[][] res = new int[matrix.length][];
		for (int i = 0; i < matrix.length; i++) {
			res[i] = new int[matrix[i].length];
			for (int k = 0; k < matrix[i].length; k++) {
				res[i][k] = matrix[i][k];
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int k = 0; k < matrix[i].length; k++) {
				if (matrix[i][k] == 0) {
					setZeroRow(res, i, k + 1, true);
					setZeroRow(res, i, k - 1, false);
					setZeroCol(res, i + 1, k, true);
					setZeroCol(res, i - 1, k, false);
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = res[i];
		}
	}

	private void setZeroRow(int[][] m, int x, int y, boolean f) {
		if (f) {
			if (y >= m[x].length)
				return;
			// System.out.println(x + ", " + y + " = " + m[x][y]);
			m[x][y] = 0;
			// System.out.println(x + ", " + y + " = " + m[x][y]);
			setZeroRow(m, x, ++y, f);
		} else {
			if (y < 0)
				return;
			m[x][y] = 0;
			setZeroRow(m, x, --y, f);
		}
	}

	private void setZeroCol(int[][] m, int x, int y, boolean f) {
		if (f) {
			if (x >= m.length)
				return;
			m[x][y] = 0;
			setZeroCol(m, ++x, y, f);
		} else {
			if (x < 0)
				return;
			m[x][y] = 0;
			setZeroCol(m, --x, y, f);
		}
	}
}
