package test.codingtest.dp;

import java.util.HashMap;

public class JumpGame2 {
	// *****
	// 
	class Solution {
		public int jump(int[] nums) {
			if (nums.length <= 1) {
				return 0;
			}
			HashMap<Integer, Integer> jumpMap = new HashMap<>();
			int jump = jump(nums, 0, jumpMap);
			// System.out.println(jumpMap);
			return jump;
		}

		private int jump(int[] nums, int i, HashMap<Integer, Integer> jumpMap) {
			if (i >= nums.length - 1) {
				return 0;
			} else if (nums[i] == 0) {
				return Integer.MAX_VALUE;
			}
			int j = jumpMap.computeIfAbsent(i, k -> Integer.MAX_VALUE);
			if (j < Integer.MAX_VALUE) {
				return j;
			}
			int idx = 0;
			while (++idx <= nums[i]) {
				j = Math.min(j, jump(nums, idx + i, jumpMap));
			}
			if (j < Integer.MAX_VALUE) {
				jumpMap.put(i, ++j);
			}
			return j;
		}
	}
}
