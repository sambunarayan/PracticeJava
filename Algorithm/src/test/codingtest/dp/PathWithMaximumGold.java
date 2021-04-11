package test.codingtest.dp;

public class PathWithMaximumGold {

	// LeetCode 1219.
	// Using DFS and Backtracking Algorithm.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getMaximumGold(int[][] grid) {
		int max = 0;
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[x].length; y++) {
				max = Math.max(max, find(grid, x, y));
			}
		}
		return max;
	}

	private int find(int[][] grid, int x, int y) {
		if ((x < 0 || x >= grid.length) || (y < 0 || y >= grid[x].length)) {
			return 0;
		} else if (grid[x][y] == 0) {
			return 0;
		}
		int thisGold = grid[x][y];
		int max = 0;
		grid[x][y] = 0;
		max = Math.max(max, find(grid, x - 1, y));
		max = Math.max(max, find(grid, x + 1, y));
		max = Math.max(max, find(grid, x, y - 1));
		max = Math.max(max, find(grid, x, y + 1));
		grid[x][y] = thisGold;
		return thisGold + max;
	}

}
