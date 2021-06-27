package test.codingtest.sort;

import java.util.Arrays;

public class LargestNumber {

	// *****
	// leetCode.179 Largest Number
	// Using comparator
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        // for (String s : asStrs) {
        //     System.out.print(s + " ");
        // }
        // System.out.println();
        Arrays.sort(asStrs, (String a, String b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });
        // for (String s : asStrs) {
        //     System.out.print(s + " ");
        // }
        // System.out.println();
        if (asStrs[0].charAt(0) == '0') {
            return "0";
        }
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }
        return largestNumberStr;
    }

}
