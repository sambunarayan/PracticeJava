package test.codingtest.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CombinationSum4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String in1 = scan.next();
		int target = Integer.parseInt(scan.next());
		String[] arr = in1.replace("[", "").replace("]", "").split(",");
		int[] nums = Arrays.stream(arr).mapToInt(s -> Integer.parseInt(s)).toArray();
		System.out.println("res -> " + new CombinationSum4().combinationSum4(nums, target));
	}
	
	public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        find(nums, target, map);
        return map.get(target);
    }
    
    private int find(int[] nums, int target, Map<Integer, Integer> map) {
        if (target == 0) {
            return 1;
        } else if (target < 0) {
            return 0;
        } else if (map.containsKey(target)) {
            return map.get(target);
        }
        
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + find(nums, target - nums[i], map);
        }
        map.put(target, count);
        
        return count;
    }

}
