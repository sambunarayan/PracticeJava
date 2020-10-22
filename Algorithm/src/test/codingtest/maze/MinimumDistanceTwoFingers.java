package test.codingtest.maze;

import java.util.Scanner;

public class MinimumDistanceTwoFingers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String word = scan.next();
		int res = new MinimumDistanceTwoFingers().minimumDistance(word);
		System.out.println("res --> " + res);
	}
	public int minimumDistance(String word) {
        char[] words = word.toCharArray();
        
        int[][] grid = new int[26][26];
        for (int i = 0; i < grid.length; i++) {
        	for (int k = 0; k < grid[i].length; k++) {
        		grid[i][k] = Integer.MAX_VALUE;
        	}
        }
        int max = 0;
        int cost = 0;
        for (int i = 0; i < words.length - 1; i++) {
        	int min = Integer.MAX_VALUE;
        	int c = words[i] - 'A';
            int x = c / 6;
            int y = c % 6;
//            System.out.println(words[i] + " -> x:" + x + ", y:" + y);
        	for (int k = i + 1; k < words.length; k++) {
        		grid[c][words[k] - 'A'] = find(words, x, y, k);
        		min = Math.min(min, grid[c][words[k] - 'A']);
//        		System.out.println("  " + words[i] + "," + words[k] + " : " + grid[c][words[k] - 'A']);
        	}
        	cost += min;
        	max = Math.max(max, min);
        }
        return cost - max;        
    }
    
    private int find(char[] words, int x, int y, int idx) {
        int cost = 0;
        int targetC = words[idx] - 'A';
        int targetX = targetC / 6;
        int targetY = targetC % 6;
//        System.out.print("  " + words[idx] + " -> x:" + targetX + ", y:" + targetY + " -> ");
        cost += Math.abs(x - targetX);
        cost += Math.abs(y - targetY);
        return cost;
    }
}
