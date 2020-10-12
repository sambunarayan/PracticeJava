package test.codingtest.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoinChange2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int amount = Integer.parseInt(scan.next());
		String inCoin = scan.next();
		int[] coins = Arrays.stream(inCoin.split(",")).mapToInt(Integer::parseInt).toArray();
		System.out.println("result --> " + new CoinChange2().change(amount, coins));
	}
	
	public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        Arrays.sort(coins);
        int cnt = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = coins.length - 1; i >= 0; i--) {
            cnt += coinChange(amount, coins, i, map);
        }
        return cnt;
    }
    
    private int coinChange(int amount, int[]coins, int a, Map<Integer, Map<Integer, Integer>> map) {
        if (coins[a] == 1) {
            return 1;
        }
        
        Integer c = map.computeIfAbsent(a, m->new HashMap<>()).get(amount);
        if (c != null) {
            return c;
        }
        
        int cnt = 0;
        for (int i = amount/ coins[a] ;i > 0; i--) {
            int rem = amount - (i * coins[a]);
            // System.out.println(coins[a] + "," + i + "," + rem);
            if (rem != 0) {
                for (int k = a - 1; k >= 0; k--) {
                    cnt += coinChange(rem, coins, k, map);
                }
            } else {
                cnt++;
                // break;
            }
        }
        
        map.get(a).put(amount, cnt);
        
        return cnt;
    }
}
