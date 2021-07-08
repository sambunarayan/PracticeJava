package test.codingtest.dp;

public class MaximumLengthOfRepeatedSubarray {

	// *****
	// leetCode.718 Maximum Length of RepeatedSubarray 
	// Using DP to record in matrix.
	public static void main(String[] args) {
		// TODO Auto-generated method stubUse DP to record in matrix.

	}
	
	public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] matrix = new int[n1 + 1][n2 + 1];
        int max = 0;
        for (int x = 1; x < nums1.length + 1; x++) {
            for (int y = 1; y < nums2.length + 1; y++) {
                if (nums1[x - 1] == nums2[y - 1]) {
                    matrix[x][y] = matrix[x - 1][y - 1] + 1;
                } else {
                    matrix[x][y] = 0;
                }
                max = Math.max(max, matrix[x][y]);
            }
        }
        return max;
    }
}
