package test.codingtest.matrix;

import java.util.Scanner;

public class UniquePath3 {
	
	//Å@leetcodeÅ@980. Unique Paths III

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
		int res = new UniquePath3().uniquePathsIII(grid);
		System.out.println("res -> " + res);
	}
	
	private static int res = 0;
    private static int steps = 1;
    
    public int uniquePathsIII(int[][] grid) {
        int startX = 0;
        int startY = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == 1) {
                    startX = x;
                    startY = y;
                } else if (grid[x][y] == 0) {
                    steps++;
                }
            }
        }
        step(grid, startX - 1, startY, 1);
        step(grid, startX + 1, startY, 1);
        step(grid, startX, startY - 1, 1);
        step(grid, startX, startY + 1, 1);
        return res;
    }
    
    private void step(int[][] grid, int x, int y, int s) {
        if ((x < 0 || x >= grid.length)
            || (y < 0 || y >= grid[x].length)) {
            return;
        } else if (grid[x][y] == 1) {
            return;
        } else if (grid[x][y] == -1) {
            return;
        } else if (grid[x][y] == 2) {
            // System.out.println("steps = " + steps + ", s = " + s);
            if (s == steps) {
                res++;
            }
            return;
        }
        grid[x][y] = 1;
        step(grid, x - 1, y, s + 1);
        step(grid, x + 1, y, s + 1);
        step(grid, x, y - 1, s + 1);
        step(grid, x, y + 1, s + 1);
        grid[x][y] = 0;
    }

}
