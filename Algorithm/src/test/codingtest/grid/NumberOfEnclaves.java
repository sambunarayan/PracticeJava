package test.codingtest.grid;

public class NumberOfEnclaves {

	// ***
	// leetcode 1020.Number of Enclaves
	// Using DFS Algorithm

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numEnclaves(int[][] grid) {
		int res = 0;
		for (int y = 0; y < grid[0].length; y++) {
			// first row and last row
			walk(grid, 0, y);
			walk(grid, grid.length - 1, y);
		}
		for (int x = 1; x < grid.length - 1; x++) {
			// first column and last column
			walk(grid, x, 0);
			walk(grid, x, grid[x].length - 1);
		}
		// count 1
		for (int x = 1; x < grid.length - 1; x++) {
			for (int y = 1; y < grid[x].length - 1; y++) {
				if (grid[x][y] == 1) {
					res++;
				}
			}
		}
		return res;
	}

	private void walk(int[][] grid, int x, int y) {
		if ((x < 0 || x >= grid.length) || (y < 0 || y >= grid[x].length)) {
			return;
		} else if (grid[x][y] == 0 || grid[x][y] == 2) {
			return;
		}
		grid[x][y] = 2;
		walk(grid, x + 1, y);
		walk(grid, x - 1, y);
		walk(grid, x, y + 1);
		walk(grid, x, y - 1);
	}
}
