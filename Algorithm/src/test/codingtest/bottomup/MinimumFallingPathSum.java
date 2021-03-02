package test.codingtest.bottomup;

public class MinimumFallingPathSum {

	// leetcode.931. Minimum Falling Path Sum

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minFallingPathSum(int[][] matrix) {
        for (int r = matrix.length - 2; r >= 0; r--) {
            for (int c = 0; c < matrix[r].length; c++) {
                int min = matrix[r + 1][c];
                min = c - 1 >= 0 ? Math.min(matrix[r + 1][c - 1], min) : min;
                min = c + 1 < matrix[r].length ? Math.min(matrix[r + 1][c + 1], min) : min;
                matrix[r][c] += min;
            }
        }
        int res = matrix[0][0];
        for (int i = 1; i < matrix[0].length; i++) {
            res = Math.min(matrix[0][i], res);
        }
        return res;
    }
}
