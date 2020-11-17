package test.codingtest.dp;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
	
	// leetcode 494 Target Sum
	// Dynamic programming

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 1) {
            if (nums[0] == S || -nums[0] == S) {
                return 1;
            } else {
                return 0;
            }
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        Map<Integer, Integer> m = new HashMap<>();
        if (nums[nums.length - 1] == 0) {
            m.put(nums[nums.length - 1], 2);
        } else {
            m.put(nums[nums.length - 1], 1);
            m.put(nums[nums.length - 1] * -1, 1);
        }
        map.put(nums.length - 1, m);
        for (int i = nums.length - 2; i > 0; i--) {
            Map<Integer, Integer> bef = map.get(i + 1);
            m = new HashMap<>();
            for (int k : bef.keySet()) {
                int val = k + nums[i];
                if (m.containsKey(val)) {
                    int count = m.get(val) + bef.get(k);
                    m.replace(val, count);
                } else {
                    m.put(val, bef.get(k));
                }
                val = k + (nums[i] * - 1);
                if (m.containsKey(val)) {
                    int count = m.get(val) + bef.get(k);
                    m.replace(val, count);
                } else {
                    m.put(val, bef.get(k));
                }
            }
            map.put(i, m);
        }
        int res = 0;
        int key = (S + nums[0]) * -1;
        Integer val = map.get(1).get(key);
        if (val != null)  {
            res += val;
        }
        key = (S - nums[0]);
        val = map.get(1).get(key);
        if (val != null)  {
            res += val;
        }
        return res;
    }

}
