
// 839. Similar String Groups
// 3 steps
// First make the adjency nodes map within the numSimilarGroups function, only if isSimilar is true
// Second implement isSimilar function at most only two or zero letters in both the string should be different to be considered similar
// Traditional dfs traversal marking all visited, if it returns that means it has finished traversing one level and you have found one group
class Solution {
	public void dfs(int u, HashMap<Integer, List<Integer>> map, boolean[] visited) {

		visited[u] = true;
		if (map.get(u) != null) {
			for (int v : map.get(u)) {
				if (!visited[v]) {
					dfs(v, map, visited);
				}
			}
		}
	}
	public boolean isSimilar(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
			}
		}
		return count == 2 || count == 0;
	}
	public int numSimilarGroups(String[] strs) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			for (int j = i + 1; j < strs.length; j++) {
				if (isSimilar(strs[i], strs[j])) {
					if (!map.containsKey(i)) {
						map.put(i, new LinkedList<>());
					}
					if (!map.containsKey(j)) {
						map.put(j, new LinkedList<>());
					}

					map.get(i).add(j);
					map.get(j).add(i);
				}
			}

		}
		boolean[] visited = new boolean[strs.length];
		int count = 0;
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				dfs(i, map, visited);
				count++;
			}
		}
		return count;
	}
}
