package graph;

public class NumberOfIslands {

	public static void main(String[] args) {
		
		char[][] grid = {{'1','1','0','0','0'}, 
						 {'1','1','0','0','0'}, 
						 {'0','0','1','0','0'}, 
						 {'0','0','0','1','1'}};
		
		System.out.println(numIslands(grid));
	}

	public static int numIslands(char[][] grid) {

		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}

		return count;
	}
	
	static int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	static int x;
	static int y;

	public static void dfs(char[][] grid, int i, int j) {

		grid[i][j] = '0';

		for (int[] dir : dirs) {
			
			x = i + dir[0];
			y = j + dir[1];
			
			if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
				continue;
			}
			
			dfs(grid, x, y);
		}
	}

}
