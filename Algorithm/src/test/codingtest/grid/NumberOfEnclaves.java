package test.codingtest.grid;

public class NumberOfEnclaves {
	
	// leetcode 1020.Number of Enclaves
	// Not yet solved.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numEnclaves(int[][] grid) {
        int res = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == 0 || grid[x][y] == 3) {
                    continue;
                } else if (grid[x][y] == 1) {
                    walk(grid, x, y, false);
                }
                if (grid[x][y] != 3) {
                    grid[x][y] = 4;
                    res++;
                }
            }
        }
        // for (int x = 0; x < grid.length; x++) {
        //     for (int y = 0; y < grid[x].length; y++) {
        //         System.out.print(grid[x][y] + " ");
        //     }
        //     System.out.println();
        // }
        return res;
    }
    
    private boolean walk(int[][] grid, int x, int y, boolean canWalk) {
        if ((x < 0 || x >= grid.length)
            || (y < 0 || y >= grid[x].length)) {
            return true;
        } else if (grid[x][y] == 0 || grid[x][y] == 2 || grid[x][y] == 4) {
            return canWalk;
        } else if (grid[x][y] == 3) {
            return true;
        }
        if (!canWalk) {
            grid[x][y] = 4;
            boolean res = false;
            res = walk(grid, x + 1, y, res);
            res = walk(grid, x - 1, y, res);
            res = walk(grid, x, y + 1, res);
            res = walk(grid, x, y - 1, res);
            if (res) {
                grid[x][y] = 3;  
            } else {
                grid[x][y] = 4;    
            }
            return res;
        } else {
            grid[x][y] = 3;
            walk(grid, x + 1, y, canWalk);
            walk(grid, x - 1, y, canWalk);
            walk(grid, x, y + 1, canWalk);
            walk(grid, x, y - 1, canWalk);
            return canWalk;
        }
    }
}
