package test.codingtest.etc;

public class MaximumProductOfThreeNumbers {
	
	// ***
	// leetCode.628 Maximum Product of Three Numbers.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private int max = Integer.MIN_VALUE;

    public int maximumProduct(int[] nums) {
        find(nums, 0, 1, 1);
        return max;
    }
    
    private void find(int[] nums, int idx, int multipleNum, int n) {
        if (idx >= nums.length || n > 3) {
            max = Math.max(max, multipleNum);
            return;
        }
        for (int i = idx; i < nums.length - (3 - n); i++) {
            find(nums, i + 1, multipleNum * nums[i], n + 1);
        }
    }

}
