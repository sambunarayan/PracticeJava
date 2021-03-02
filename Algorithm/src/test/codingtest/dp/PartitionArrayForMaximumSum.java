package test.codingtest.dp;

import java.util.Arrays;
import java.util.Scanner;

public class PartitionArrayForMaximumSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String in1 = scan.next();
		int target = Integer.parseInt(scan.next());
		String[] arr = in1.replace("[", "").replace("]", "").split(",");
		int[] nums = Arrays.stream(arr).mapToInt(s -> Integer.parseInt(s)).toArray();
		System.out.println(new PartitionArrayForMaximumSum().maxSumAfterPartitioning(nums, target));
	}
	
	public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int maxValue = arr[i];
            for (int j = 0; j < k; j++) {
                if (i - j >= 0) {
                    if (arr[i - j] > maxValue) {
                        maxValue = arr[i - j];
                    }
                    if (i - j - 1 >= 0) {
                        dp[i] = Math.max(dp[i], dp[i - j - 1] + maxValue * (j + 1));
                    } else {
                        dp[i] = Math.max(dp[i], maxValue * (j + 1));
                    }
                    System.out.println(i + "," + dp[i]);
                }
            }
        }
        return dp[arr.length - 1];
    }

}
