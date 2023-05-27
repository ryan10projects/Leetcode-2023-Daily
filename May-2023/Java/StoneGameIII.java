// 1406. Stone Game III
// contraints
// choice
// goal
class Solution {
	int n;
	int[] stones;
	int choice1 = 0;
	int[] dp;
	public int solve(int i) {
		// contraints
		if (i >= n) return 0;
		// memoization
		if (dp[i] != -1) return dp[i];
        // pick one time and find difference
		int choice = stones[i] - solve(i + 1);
		if (i + 1 < n) {
			// pick twice and find difference
			choice = Math.max(choice, stones[i] + stones[i + 1] - solve(i + 2));
		}
		if (i + 2 < n) {
			// pick thrice and find difference
			choice = Math.max(choice, stones[i] + stones[i + 1] + stones[i + 2] - solve(i + 3));
		}
		// memoization // checkpoint // result
		return dp[i] = choice;
	}

	public String stoneGameIII(int[] stoneValue) {
		stones = stoneValue;
		n = stoneValue.length;
		dp = new int[n + 1];
		Arrays.fill(dp, -1);
		int answer = solve(0);
		if (answer > 0) return "Alice";
		if (answer < 0) return "Bob";
		return "Tie";
	}
}
