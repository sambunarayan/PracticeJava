package test.codingtest.dp;

import java.util.HashMap;
import java.util.Map;

public class CherryPickup2 {
	
	// leetcode 1463. Cherry Pickup II
	// Using the DP algorithm, but the processing speed is slow. Need improvement.
	// Consider Top-down Bottom-up.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int cherryPickup(int[][] grid) {
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        int res = grid[0][0] + grid[0][grid[0].length - 1];
        return res += move(grid, 1, 0, grid[0].length - 1, map);
    }
    
    private int move(int[][] grid, int i, int r1J, int r2J, Map<Integer, Map<String, Integer>> map) {
        if (i >= grid.length) {
            return 0;
        }
        String key = "" + r1J + r2J;
        Integer val = map.computeIfAbsent(i, m->new HashMap<>()).get(key);
        if (val != null) {
            return val;
        }
        
        // System.out.println("------- line : " + i + " -------");
        int res = 0;
        int fromR1J = (r1J - 1 < 0) ? 0 : r1J - 1;
        int toR1J = (r1J + 1 >= grid[i].length) ? grid[i].length - 1 : r1J + 1;
        while (fromR1J <= toR1J) {
            int fromR2J = (r2J - 1 < 0) ? 0 : r2J - 1;
            int toR2J = (r2J + 1 >= grid[i].length) ? grid[i].length - 1 : r2J + 1;
            if (fromR1J > fromR2J) {
                fromR2J = fromR1J;
            }
            while (fromR2J <= toR2J) {
                int cherry = grid[i][fromR1J];
                if (fromR1J != fromR2J) {
                    cherry +=  grid[i][fromR2J];    
                }
                // System.out.println(fromR1J + "," + fromR2J + "," + cherry);
                cherry += move(grid, i + 1, fromR1J, fromR2J, map);
                res = Math.max(res, cherry);
                fromR2J++;
            }
            fromR1J++;
        }
        map.get(i).put(key, res);
        // System.out.println(i - 1+ "," + key + "," + res);
        return res;
    }	

}
