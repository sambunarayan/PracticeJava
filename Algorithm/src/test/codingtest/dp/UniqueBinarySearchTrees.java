package test.codingtest.dp;

public class UniqueBinarySearchTrees {

	// leetCode.96 Unique Binary Search Trees
	// Using Dynamic Programming algorithm.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int p1 = 0;
            int p2 = i - 1;
            while (p1 <= i - 1 && p2 >= 0) {
                dp[i] += (dp[p1++] * dp[p2--]);
            }
        }
        return dp[n];
    }
}
