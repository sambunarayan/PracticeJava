package test.codingtest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LargestSum {

	// leet code 813.Largest Sum of Averages
	// Dynamic Programing
	// Memo in memory the already known values. And recycle values in memory.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr;
		String in1;
		String in2;
		
		in1 = scan.next();
		String[] arrStr = in1.split(",");
		arr = Arrays.stream(arrStr).mapToInt(s->Integer.parseInt(s)).toArray();
		in2 = scan.next();
		System.out.println("result --> " + largestSumOfAverages(arr, Integer.parseInt(in2)));
	}
	
	public static double largestSumOfAverages(int[] A, int K) {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        return part(A, K, 0, map);
    }
    
    private static double part(int[] A, int K, int idx, Map<Integer, Map<Integer, Double>> map) {
    	if (idx == A.length - 1) {
    		return A[idx];
    	}
        Double val = map.computeIfAbsent(K, k->new HashMap<>()).get(idx);
        if (val != null) {
            return val;
        }
        double thisPartSum = 0.0;
        double sum = 0.0;
        double best = 0.0;
        for (int i = idx; i < A.length; i++) {
        	thisPartSum += A[i];
            if (K > 1) {
            	if (i >= A.length - 1) break;
                sum = (thisPartSum / ((i - idx) + 1)) + part(A, K - 1, i + 1, map);
                best = Math.max(best, sum);
            }
        }
        if (K <= 1) {
            best = thisPartSum / (A.length - idx);
        }
        map.get(K).put(idx, best);
//        System.out.println(K + "->" + best);
        return best;
    }

}
