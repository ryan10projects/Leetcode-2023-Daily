// Longest Cycle in a Graph
// Algorithm
// First we find if there is a cycle in a directed graph
// For that we need two things
// visited array and recusrion array 
// visited array will keep track of the nodes it visits
// recursion array will check if its within the cycle loop, if it is -1 means its a dead end and recursion will  be set to false
class Solution {
	int res = -1;
	public void dfs(int[] edges, int u, boolean[] visited, int[] count, boolean[] recursion) {
		int v = edges[u];
		if (u != -1) {
			visited[u] = recursion[u] = true;
			if (v != -1 && !visited[v]) {
				count[v] = count[u] + 1;
				dfs(edges, v, visited, count, recursion);
			}
			else if (v != -1 && recursion[v]) {
				res = Math.max(res, count[u] - count[v] + 1);
			}
				recursion[u] = false;
		}
	}
	public int longestCycle(int[] edges) {
		int n = edges.length;
		int[] count = new int[n];
		Arrays.fill(count, 1);
		boolean[] visited = new boolean[n];
		boolean[] recursion = new boolean[n];
		for (int i = 0; i < edges.length; i++) {
			if (visited[i] != true) {
				dfs(edges, i, visited, count, recursion);
			}
		}
		return res;
	}
}
