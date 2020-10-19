package test.codingtest.etc;

import java.util.Arrays;
import java.util.Scanner;

public class ReducingDishes {
	
	// leetcode 1402. Reducing Dishes

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		String[] datas = input.substring(1, input.length() - 1).split(",");
		int[] satisfaction = Arrays.stream(datas).mapToInt(Integer::parseInt).toArray();
		int res = new ReducingDishes().maxSatisfaction(satisfaction);
		System.out.println("res -> " + res);
	}
	
	public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max = -1;
        int i = 0;
        while (i < satisfaction.length) {
            int j = i;
            int k = 1;
            int sum = 0;
            while (j < satisfaction.length) {
                sum += satisfaction[j++] * k++;
            }
            max = Math.max(max, sum);
            i++;
        }
        return max < 0 ? 0 : max;
    }
}
