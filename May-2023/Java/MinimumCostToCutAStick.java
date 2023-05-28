// 1547. Minimum Cost to Cut a Stick (Hard)
// algorithm
// cutting problem tenplate
// create a new array, add 0 at the start and total length of ruler at the end (to find out length)
// sort the original cut array
// copy it into new array
// cut it from the center of cuts array(first add the total length of ruler) 
// call recursion on left and right
class Solution {
	int[][] dp;
	public int solve(int[] newcuts, int left, int right) {
		if (right - left < 2) return 0;
		if (dp[left][right] != -1) return dp[left][right];
		int result = Integer.MAX_VALUE;
		for (int i = left + 1; i < right; i++) {
			int cost = (newcuts[right] - newcuts[left]) + solve(newcuts, left, i) + solve(newcuts, i, right);
			result = Math.min(result, cost);
		}
		return dp[left][right] = result;
	}

	public int minCost(int n, int[] cuts) {

		int m = cuts.length;
		int[] newcuts = new int[m + 2];
		dp = new int[m + 3][m + 3];
		newcuts[0] = 0;
		newcuts[m + 1] = n;
		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}
		Arrays.sort(cuts);
		for (int i = 1; i < m + 1; i++) {
			newcuts[i] = cuts[i - 1];
		}
		return solve(newcuts, 0, newcuts.length - 1);
	}
}
