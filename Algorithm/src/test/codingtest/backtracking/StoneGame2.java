package test.codingtest.backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class StoneGame2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String in1 = scan.next();
		String[] arr = in1.replace("[", "").replace("]", "").split(",");
		int[] nums = Arrays.stream(arr).mapToInt(s -> Integer.parseInt(s)).toArray();
		System.out.println(new StoneGame2().stoneGameII(nums));
	}
	
	private int res = 0;
    public int stoneGameII(int[] piles) {
        game(piles, 0, 0, true, 0);
        return res;
    }
    
    private void game(int[] piles, int idx, int score, boolean alice, int M) {
        if (idx >= piles.length) {
            res = Math.max(res, score);
            return;
        }
        if (alice) {
            for (int i = idx; i < piles.length -1; i++) {
                score += piles[i];
                game(piles, i + 1, score, false, ++M);
            }
        } else {
            for (int i = idx; i < piles.length && i < idx + M * 2; i++) {
                game(piles, i + 1, score, true, 0);
            }
        }
    }

}
