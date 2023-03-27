// 64. Minimum Path Sum
class Solution {
	public:
	int arr[201][201];
	//memset(arr,-1,sizeOf(arr));
	int solve(vector<vector<int>> & grid, int i, int j, int m, int n) {
		// return the last grid, do not return the prev
		if (i == m && j == n) {
			return grid[i][j];
		}
		if (arr[i][j] != -1) {
			return arr[i][j];
		}
		// if i on the last row, you can move only right
		if (i == m) {
			return arr[i][j] = grid[i][j] + solve(grid, i, j + 1, m, n);
		}
		// if j is on last column, you can move only down
		else if (j == n) {
			return arr[i][j] = grid[i][j] + solve(grid, i + 1, j, m, n);
		}
		//choice
		// move left or down
		else {
			return arr[i][j] = grid[i][j] + min(solve(grid, i + 1, j, m, n), solve(grid, i, j + 1, m, n));
		}
	}

	int minPathSum(vector<vector<int>> & grid) {
		int m = grid.size() - 1;
		int n = grid[0].size() - 1;
		memset(arr, -1, sizeof(arr));
		return solve(grid, 0, 0, m, n);
	}
};
