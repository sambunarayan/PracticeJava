package test.codingtest.bottomup;

public class MinimumFallingPathSum2 {

	// *****
	// leetCode 1289 hard Minimum Falling Path Sum 2.
	// Using Dynamic Programming and Bottom-up Algorithm.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minFallingPathSum(int[][] arr) {
		int[][] minArr = new int[2][2];
		minArr[0][1] = Integer.MAX_VALUE;
		minArr[1][1] = Integer.MAX_VALUE;
		for (int i = 0; i < arr[0].length; i++) {
			if (arr[arr.length - 1][i] <= minArr[0][1]) {
				minArr[1][0] = minArr[0][0];
				minArr[1][1] = minArr[0][1];
				minArr[0][0] = i;
				minArr[0][1] = arr[arr.length - 1][i];
			} else if (arr[arr.length - 1][i] <= minArr[1][1]) {
				minArr[1][0] = i;
				minArr[1][1] = arr[arr.length - 1][i];
			}
		}
		for (int r = arr.length - 2; r >= 0; r--) {
			int[][] tempArr = new int[2][2];
			tempArr[0][1] = Integer.MAX_VALUE;
			tempArr[1][1] = Integer.MAX_VALUE;
			for (int c = 0; c < arr[r].length; c++) {
				arr[r][c] += (c != minArr[0][0]) ? minArr[0][1] : minArr[1][1];
				if (arr[r][c] <= tempArr[0][1]) {
					tempArr[1][0] = tempArr[0][0];
					tempArr[1][1] = tempArr[0][1];
					tempArr[0][0] = c;
					tempArr[0][1] = arr[r][c];
				} else if (arr[r][c] <= tempArr[1][1]) {
					tempArr[1][0] = c;
					tempArr[1][1] = arr[r][c];
				}
			}
			minArr = tempArr;
		}
		return minArr[0][1];
	}
}
