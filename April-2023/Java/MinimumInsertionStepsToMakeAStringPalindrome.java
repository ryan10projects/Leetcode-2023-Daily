// 1312. Minimum Insertion Steps to Make a String Palindrome
class Solution {
	int[][] memset;
	public int dfs(String s, int i, int j) {
		// constraint
		if (i >= j) return 0;
                // goal
		if (s.charAt(i) == s.charAt(j)) {
			return dfs(s, i + 1, j - 1);
		}
		if (memset[i][j] != -1) {
			return memset[i][j];
		}
		//choice
		return memset[i][j] = 1 + Math.min(dfs(s, i + 1, j), dfs(s, i, j - 1));
	}
	public int minInsertions(String s) {
		memset = new int[501][501];
		for (int[] mem : memset) {
			Arrays.fill(mem, -1);
		}
		return dfs(s, 0, s.length() - 1);
	}
}
