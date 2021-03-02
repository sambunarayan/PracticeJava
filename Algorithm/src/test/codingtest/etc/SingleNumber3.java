package test.codingtest.etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumber3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                int k = i + 2;
                while (k < nums.length) {
                    if (nums[k - 1] != nums[k]) break;
                    k++;
                }
                i = k - 1;
            } else {
                res.add(nums[i]);
            }
        }
        return res.stream().mapToInt(i->(int)i).toArray();
    }

}
