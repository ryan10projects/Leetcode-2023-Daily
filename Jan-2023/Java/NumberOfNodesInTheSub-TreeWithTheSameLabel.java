//1519. Number of Nodes in the Sub-Tree With the Same Label
class Solution {
	public int[] dfs(HashMap<Integer, List<Integer>> map, int child, int parent, int[] count, String labels) {
		//record the parent's label
		int[] parent_res = new int[26];
		parent_res[labels.charAt(child) - 'a']++;
		for (int i : map.get(child)) {
			//dont reiterate to the parent again
			if (i == parent) continue;
			//get the child's' labels
			int[] sub_res = dfs(map, i, child, count, labels);
			for (int j = 0; j < 26; j++) {
				//if a child has a label add it to parent
				//if a is twice it will be 2 in parent_res after adding
				parent_res[j] += sub_res[j];
			}
		}
		//add it to the array to be returned and next recursion initialize parent_res again
		count[child] = parent_res[labels.charAt(child) - 'a'];

		return parent_res;
	}
	public int[] countSubTrees(int n, int[][] edges, String labels) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int[] i : edges) {
			int parent = i[0];
			int child = i[1];
			if (!map.containsKey(parent)) {
				map.put(parent, new LinkedList<>());

			}
			if (!map.containsKey(child)) {
				map.put(child, new ArrayList<>());
			}
			map.get(parent).add(child);
			map.get(child).add(parent);
		}
		int[] count = new int[n];

		dfs(map, 0, -1, count, labels);
		return count;
	}
}
