package test.codingtest.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberOfIslands {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		
		String line = "";
		do {
			line = scan.next();
			if (!line.equals("[") && !line.equals("]")) {
				list.add(line);
			}
		} while (!line.equals("]"));
		
		char[][] grid = new char[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			str = str.replace("[", "").replace("]", "").replace("\"", "").replace(",", "").trim();
			grid[i] = new char[str.length()];
			for (int k = 0; k < str.length(); k++) {
				grid[i][k] = str.charAt(k);
			}
		}
		
		System.out.println("res -> " + new NumberOfIslands().numIslands(grid));
	}
	
	public int numIslands(char[][] grid) {
        int res = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == '1') {
                    res++;
                    find(grid, x, y);
                }
            }
        }
        return res;
    }
    
    private void find(char[][] grid, int x, int y) {
        if (grid[x][y] == '0') {
            return ;
        } else if (grid[x][y] == '2') {
            return ;
        } else {
            grid[x][y] = '2';
            if (x + 1 < grid.length) find(grid, x + 1, y);
            if (x - 1 >= 0) find(grid, x - 1, y);
            if (y + 1 < grid[x].length) find(grid, x, y + 1);
            if (y - 1 >= 0) find(grid, x, y - 1);
        }
    }

}
