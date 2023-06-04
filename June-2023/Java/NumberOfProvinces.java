// 547. Number of Provinces
// simple dfs
class Solution {
	int count = 0;
	public void dfs(HashMap<Integer, List<Integer>> map, Set<Integer> visited, int u) {
		if (visited.contains(u)) return;
		for (int v : map.getOrDefault(u, new LinkedList<>())) {
			if (!visited.contains(v)) {
				visited.add(u);
				dfs(map, visited, v);
			}
		}
	}
	public int findCircleNum(int[][] isConnected) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < isConnected.length; i++) {
			for (int j = 0; j < isConnected[0].length; j++) {
				if (isConnected[i][j] == 1) {
					if (!map.containsKey(i)) {
						map.put(i, new LinkedList<>());
					}
					map.get(i).add(j);
				}
			}
		}
		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < isConnected.length; i++) {
			if (!visited.contains(i)) {
				dfs(map, visited, i);
				count++;
			}
		}
		return count;
	}
}
