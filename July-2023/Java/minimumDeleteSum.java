class Solution {
	int m, n;
	int[][] dp;
	public int solve(String s1, String s2, int i, int j) {
		// constraint 1
		if (i >= m && j >= n) return 0;

		if (dp[i][j] != -1) return dp[i][j];
		// constraint 2 (if one string is empty, delete another string's character)
		if (i >= m) return dp[i][j] = s2.charAt(j) + solve(s1, s2, i, j + 1);

		// 3. same as constraint 2
		else if (j >= n) return dp[i][i] = s1.charAt(i) +  solve(s1, s2, i + 1, j);

		// if same no need to delete so dont add and skip index
   
		if (s1.charAt(i) == s2.charAt(j)) {
			return  dp[i][j] = solve(s1, s2, i + 1, j + 1);
		}
		// choice pick from s1 or s2
		int take_s = s1.charAt(i) + solve(s1, s2, i + 1, j);
		int take_j = s2.charAt(j) + solve(s1, s2, i, j + 1);
		//goal
		return dp[i][j] = Math.min(take_s, take_j);
	}
	public int minimumDeleteSum(String s1, String s2) {
		dp = new int[1002][1002];
		for (int[] arr : dp) Arrays.fill(arr, -1);
		m = s1.length();
		n = s2.length();
		return solve(s1, s2, 0, 0);
	}
}
