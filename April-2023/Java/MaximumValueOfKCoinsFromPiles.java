// 2218. Maximum Value of K Coins From Piles
// Recursion
// Constraint
// Choice
// Goal

class Solution {
	int[][] mem;
	public int solve(List<List<Integer>> piles, int i, int k) {
		// constraint
		if (i >= piles.size()) return 0;
		if (mem[i][k] != -1) {
			return mem[i][k];
		}
		//choice
		// skip the pile
		int not_taken = solve(piles, i + 1, k);
		int sum = 0;
		int taken = 0;
		for (int j = 0; j < Math.min(k, piles.get(i).size()); j++) {
			sum += piles.get(i).get(j);
			// take the pile
			taken = Math.max(taken, sum + solve(piles, i + 1, k - (j + 1)));

		}
        // Goal
		return mem[i][k] = Math.max(taken, not_taken);
	}


	public int maxValueOfCoins(List<List<Integer>> piles, int k) {
		mem = new int[1001][2001];
		for (int[] i : mem) {
			Arrays.fill(i, -1);
		}
		return solve(piles, 0, k);
	}
}
