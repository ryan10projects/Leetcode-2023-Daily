// 785. Is Graph Bipartite?
class Solution {
	public boolean dfs(int[][] graph, int u, int[] visited, int curr) {
		visited[u] = curr;
		for (int v : graph[u]) {
			if (visited[v] == visited[u]) {
				return false;
			}
			if (visited[v] == -1) {
				if (dfs(graph, v, visited, 1 - curr) == false) return false;
			}
		}
		return true;
	}
	public boolean isBipartite(int[][] graph) {
		int[] visited = new int[graph.length];
		Arrays.fill(visited, -1);
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == -1) {
				if (dfs(graph, i, visited, 0) == false) return false;
			}
		}

		return true;
	}
}
