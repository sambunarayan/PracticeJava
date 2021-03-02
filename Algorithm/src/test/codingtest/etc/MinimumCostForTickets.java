package test.codingtest.etc;

import java.util.Arrays;
import java.util.Scanner;

import test.codingtest.backtracking.StoneGame2;

public class MinimumCostForTickets {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String in1 = scan.next();
		String[] arr = in1.replace("[", "").replace("]", "").split(",");
		int[] days = Arrays.stream(arr).mapToInt(s -> Integer.parseInt(s)).toArray();
		
		String in2 = scan.next();
		arr = in2.replace("[", "").replace("]", "").split(",");
		int[] costs = Arrays.stream(arr).mapToInt(s -> Integer.parseInt(s)).toArray();
		
		System.out.println(new MinimumCostForTickets().mincostTickets(days, costs));
	}

	int[] dp = new int[366];
	public int mincostTickets(int[] days, int[] costs) {
        Arrays.fill(dp, -1);
        int res = getCost(dp, 0, costs);
        for (int i = 0; i < days.length; i++) {
            System.out.println(dp[i]);
        }
        return res;
	}

	private int getCost(int[] days, int idx, int[] c) {
        if (idx >= days.length) {
            return 0;
        }
        if (dp[idx] != -1) return dp[idx];
        int w = idx;
        int m = idx;
        while (w < days.length && days[w] <= days[idx] + 6) w++;
        while (m < days.length && days[m] <= days[idx] + 29) m++;
        return dp[idx] = Math.min(getCost(days, idx + 1, c) + c[0], Math.min(getCost(days, w, c) + c[1], getCost(days, m, c) + c[2]));
	}

}
