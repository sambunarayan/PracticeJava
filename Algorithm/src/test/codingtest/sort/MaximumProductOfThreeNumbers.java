package test.codingtest.sort;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
	
	// ***
	// leetCode.628 Maximum Product of Three Numbers.
	// Using Sorting

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maximumProduct(int[] nums) {
    	Arrays.sort(nums);
        return Math.max((nums[0] * nums[1] * nums[nums.length - 1]), 
                        (nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]));
    }
}
