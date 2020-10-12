package test.codingtest.etc;

import java.util.Arrays;
import java.util.Scanner;

public class MaximizeSumOfArrayAfterKNegations {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inArr = scan.next();
		inArr = inArr.replace("[", "").replace("]", "");
		int[] A = Arrays.stream(inArr.split(",")).mapToInt(Integer::parseInt).toArray();
		int K = Integer.parseInt(scan.next());
		int res = largestSumAfterKNegations(A, K);
		System.out.println("res --> " + res);
	}
	
	public static int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int zeroIdx = -1;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0 && K > 0) {
                System.out.println(A[i]);
                A[i] *= -1;
                zeroIdx = i;
                K--;
                System.out.println(" ->" + A[i]);
            }
            sum += A[i];
        }
        if (K > 0 && K % 2 != 0) {
            zeroIdx = zeroIdx == -1 ? A.length - 1 : zeroIdx;
            sum += A[zeroIdx] * -1;
        }
        return sum;        
    }

}
