package test.codingtest.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inCoin = scan.nextLine();
		inCoin = inCoin.replace("[", "").replace("]", "").replace(" ", "");
		int[] n = Arrays.stream(inCoin.split(",")).mapToInt(Integer::parseInt).toArray();
		System.out.println("res -> " + new Task3().solution(n));
	}
	public int solution(int[] n) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n.length; i++) {
            res = Math.max(res, find(map, n, i));
        }
        return res;
    }
    
    private int find(Map<Integer, Integer> map, int[] n, int idx) {
        // Use Dynamic Programming Algorithm
        if (idx >= n.length) return 0;
        
        Integer value = map.get(idx);
        if (value != null) {
            return value;
        }
        int res = 0;
        for (int i = idx + 2; i < n.length; i++) {
            res = Math.max(res, n[idx] + find(map, n, i));
        }
        map.put(idx, res);
        return res;
    }
}
