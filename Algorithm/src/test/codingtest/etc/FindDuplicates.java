package test.codingtest.etc;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
	
	// ***
	// leetCode.442 Find All Duplicates in an Array
	// Using another arrays.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> findDuplicates(int[] nums) {
        int[] resArr = new int[nums.length + 1];
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            if (++resArr[i] >= 2) res.add(i);
        }
        return res;
    }
}
