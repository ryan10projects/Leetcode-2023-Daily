// Number of Closed Islands
// Algorithm
// boolean array not required (only for understanding)
// mark the visited land as 1 to not revisit
// keep doing dfs up,down,left,right till you find a border or 1

class Solution {
	int count = 0;
	public int closedIsland(int[][] grid) {
		if ((grid.length == 1) && (grid[0][0] == 1 || grid[0][0] == 0)) return 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					if (dfs(grid, visited, i, j)) {
						count++;
					}
				}
			}
		}
		return count;

	}

	public boolean dfs(int[][] grid, boolean[][] visited, int i, int j) {

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			return false;
		}
		if (grid[i][j] == 1) {
			visited[i][j] = true;
			return true;
		}
		grid[i][j] = 1;
		if (!visited[i][j]) {
			boolean left = dfs(grid, visited, i, j - 1);
			boolean right = dfs(grid, visited, i, j + 1);
			boolean up = dfs(grid, visited, i + 1, j);
			boolean down = dfs(grid, visited, i - 1, j);
			return left && right && up && down;
		}
		return false;

	}
}
