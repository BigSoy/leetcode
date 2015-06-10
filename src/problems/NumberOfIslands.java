package problems;

public class NumberOfIslands {
	
	private int count = 0;

	private void dfs(char[][] grid, int x, int y, boolean[][] visited, boolean start) {
		int m = grid.length;
		int n = grid[0].length;
		if(x < 0 || x >= m || y < 0 || y >= n)
			return;
		if(grid[x][y] == '1' && !visited[x][y]) {
			if(start)
				count++;
			visited[x][y] = true;
			dfs(grid, x-1, y, visited, false);
			dfs(grid, x+1, y, visited, false);
			dfs(grid, x, y-1, visited, false);
			dfs(grid, x, y+1, visited, false);
		}
	}
	
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				dfs(grid, i, j, visited, true);
			}
		}
		return count;
	}
}
