// 64. Minimum Path Sum
class Solution {
    int[][] arr = new int[201][201]; 
    public int solve(int[][] grid, int i, int j, int m, int n) {
            //goal
       	// return the last grid, do not return the prev
           if (i == m && j == n) {
            return grid[i][j];
        }
        
        if (arr[i][j] != -1) {
            return arr[i][j];
        }
        //constraints
        // if i on the last row, you can move only right
        if (i == m) {
            return arr[i][j] = grid[i][j] + solve(grid, i, j+1, m, n);
        }
     	// if j is on last column, you can move only down
        if (j == n) {
            return arr[i][j] = grid[i][j] + solve(grid, i+1, j, m, n);
        }
       // choice
       // remember you can move only left or right
        return arr[i][j] = grid[i][j] + Math.min(solve(grid, i+1, j, m, n), solve(grid, i, j+1, m, n));
    }
    
    public int minPathSum(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        for (int[] a : arr) {
            Arrays.fill(a, -1);
        }
        return solve(grid, 0, 0, m, n);
    }
}

