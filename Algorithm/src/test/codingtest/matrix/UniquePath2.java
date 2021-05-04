package test.codingtest.matrix;

import java.util.Scanner;

public class UniquePath2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String data = scan.next();
		data = data.substring(2, data.length() - 2);
		String[] arrStr = data.split("],");
		int[][] grid = new int[arrStr.length][];
		for (int i = 0; i < arrStr.length; i++) {
			String[] tmp = arrStr[i].replace("[", "").split(",");
			grid[i] = new int[tmp.length];
			for (int k = 0; k < tmp.length; k++) {
				grid[i][k] = Integer.parseInt(tmp[k]);
			}
		}
		int res = new UniquePath2().uniquePathsWithObstacles(grid);
		System.out.println("res -> " + res);
	}
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return step(obstacleGrid, 0, 0);
    }
	
	public int step(int[][] grid, int x, int y) {
		if (grid[x][y] == 1 || grid[x][y] == 2) {
			return 0;
		} else if (x == grid.length - 1 
				&& y == grid[x].length -1) {
			return 1;
		}
		int path = 0;
		grid[x][y] = 2;
		if (x + 1 >= grid.length) {
			path += step(grid, x + 1, y);
		}
		if (y + 1 >= grid[x].length) {
			path += step(grid, x, y + 1);
		}
		grid[x][y] = 0;
		return path;
	}

}
