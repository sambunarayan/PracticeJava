package test.codingtest.dp;

public class MaximumNuberOfPointsWithCost {

	// *****
	// leetCode.1937
	// Using DP algorithm.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Second answer.
	// Using DP algorithm.
	public long maxPoints(int[][] points) {
		int recLen = points.length;
		int colLen = points[0].length;
		long[] dp = new long[colLen];

		for (int x = 0; x < recLen; x++) {
			for (int y = 0; y < colLen; y++) {
				dp[y] += points[x][y];
			}
			for (int y = 1; y < colLen; y++) {
				dp[y] = Math.max(dp[y], dp[y - 1] - 1);
			}
			for (int y = colLen - 2; y >= 0; y--) {
				dp[y] = Math.max(dp[y], dp[y + 1] - 1);
			}
		}
		long maxPoints = 0;
		for (int i = 0; i < colLen; i++) {
			maxPoints = Math.max(maxPoints, dp[i]);
		}

		return maxPoints;
	}

	// The First answer.
	// Using bottom-up algorithm.
	// But, TimeLimitException occurred.
	public long maxPoints_first(int[][] points) {
		long[][] target = new long[points.length][points[0].length];
		for (int i = 0; i < points.length; i++) {
			for (int y = 0; y < points[i].length; y++) {
				target[i][y] = points[i][y];
			}
		}

		for (int x = target.length - 2; x >= 0; x--) {
			for (int i = 0; i < target[0].length; i++) {
				findMaxim(target, x + 1, i, target[x][i]);
			}
		}
		long maxPoints = 0;
		for (int i = 0; i < target[0].length; i++) {
			maxPoints = Math.max(maxPoints, target[0][i]);
		}
		return maxPoints;
	}

	private void findMaxim(long[][] points, int x, int y, long p) {
		for (int i = 0; i < points[x].length; i++) {
			long d = Math.abs(y - i);
			points[x - 1][y] = Math.max(points[x - 1][y], p + points[x][i] - d);
		}
	}

}
