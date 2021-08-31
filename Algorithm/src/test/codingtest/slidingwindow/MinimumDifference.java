package test.codingtest.slidingwindow;

import java.util.Arrays;

public class MinimumDifference {

	// leetCode.1984 Minimum Difference Between Highest and Lowest of K Scores
	// Using Sliding window algorithm.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumDifference(int[] nums, int k) {
		Arrays.sort(nums);
		int res = Integer.MAX_VALUE;
		for (int i = 0; i + k - 1 < nums.length; i++) {
			res = Math.min(res, nums[i + k - 1] - nums[i]);
		}
		return res;
	}
}
