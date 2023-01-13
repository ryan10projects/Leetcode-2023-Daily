// Longest Path With Different Adjacent Characters
class Solution {

	int result = 0;
	public int dfs(HashMap<Integer, List<Integer>> map, int curr, int parent, String s) {
		//two variables declared to pick the longest sub route if two or more valid paths are found, we pick the one with highest length
		int longest = 0;
		int second_longest = 0;
		for (int child : map.get(curr)) {
			if (child == parent) {
				continue;
			}
			int current_longest = dfs(map, child, curr, s);
			
			if (s.charAt(child) == s.charAt(curr)) continue;

			if (current_longest > second_longest) {
				second_longest = current_longest;
			}
			if (second_longest > longest) {
				int temp = longest;
				longest = second_longest;
				second_longest = temp;
			}
		}
		//all adjacent have same values (1)
		int only_root = 1;
		//answer found in sub root /\, cannot add to parent because it wont be a valid path if it has more than two endpoints
		int only_sub_root = longest + second_longest + 1;
		//answer found in sub but can added be to the parent 
		int biggest_sub_route_with_root = Math.max(longest, second_longest) + 1;
       //get the biggest length
		result = Math.max(Math.max(Math.max(only_root, only_sub_root), biggest_sub_route_with_root), result);
		//we wont return only_sub_root because it wont be added to current path
		return Math.max(only_root, biggest_sub_route_with_root);
	}

	public int longestPath(int[] parent, String s) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		if (parent.length == 1 && parent[0] == -1) return 1;
		for (int i = 1; i < parent.length; i++) {
			int u = i;
			int v = parent[i];
			if (!map.containsKey(u)) {
				map.put(u, new LinkedList<>());

			}
			if (!map.containsKey(v)) {
				map.put(v, new LinkedList<>());

			}
			map.get(u).add(v);
			map.get(v).add(u);

		}

		dfs(map, 0, -1, s);
		return result;
	}
}
