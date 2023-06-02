// 2101. Detonate the Maximum Bombs

// Algorithm

// find the distance using two bombs √(x2-x1)^2 + (y2-y1)^2

// if the radius of current bomb is equal or greater than the distance, then its within the range to explode

// use dfs to find all the bombs that are connected and return the maximum number of bombs that can be visited

class Solution {

	public void dfs(int u, Set<Integer> visited, HashMap<Integer, List<Integer>> map) {

		visited.add(u);

		for (int v : map.getOrDefault(u, new LinkedList<>())) {

			if (!visited.contains(v)) {

				visited.add(v);

				dfs(v, visited, map);

			}

		}

	}

	public int maximumDetonation(int[][] bombs) {

		HashMap<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < bombs.length; i++) {

			for (int j = 0; j < bombs.length; j++) {

				if (i == j)  continue;

				//x2-x1*y2-y1

				long x1 = bombs[i][0];

				long x2 = bombs[j][0];

				long y1 = bombs[i][1];

				long y2 = bombs[j][1];

				long distance = ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));

				// radius >= distance between two bombs

				// within range of explosion

				if ((long)bombs[i][2] * bombs[i][2] >= distance) {

					if (!map.containsKey(i)) {

						map.put(i, new LinkedList<>());

					}

					map.get(i).add(j);

				}

			}

		}

		Set<Integer> visited = new HashSet<>();

		int result = 0;

		for (int i = 0; i < bombs.length; i++) {

			dfs(i, visited, map);

			result = Math.max(result, visited.size());

			visited.clear();

		}

		return result;

	}

}
