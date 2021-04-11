package test.codingtest.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DeleteAndEarn {
	// *****
	// leet code 740. Delete and Earn
	// Dynamic Programming Algorithm.

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String in1 = scan.next();
		String[] arr = in1.replace("[", "").replace("]", "").split(",");
		int[] nums = Arrays.stream(arr).mapToInt(s -> Integer.parseInt(s)).toArray();
		System.out.println(new DeleteAndEarn().deleteAndEarn(nums));
	}

	public int deleteAndEarn(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		
		int maxValue = 0;
		for (int i : nums) {
			maxValue = Math.max(maxValue, i);
		}
		int[] values = new int[maxValue + 1];
		int[] dp = new int[maxValue + 1];
		for (int i : nums) {
			values[i] += i;
		}
		
		dp[1] = values[1];
		dp[2] = Math.max(dp[1], values[2]);
		for (int i = 3; i < dp.length; i++) {
			dp[i] = Math.max(dp[i - 2] + values[i], dp[i - 1]);
		}
		return dp[dp.length - 1];
	}
}
