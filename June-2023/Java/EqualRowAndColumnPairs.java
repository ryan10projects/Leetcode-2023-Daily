// 2352. Equal Row and Column Pairs
// store every value of one row in map as key and assign its count
// everytime you see the list while traversing through column, get the count of hashmap
class Solution {
	public int equalPairs(int[][] grid) {
		HashMap<List<Integer>, Integer> map = new HashMap<>();

        // looping through rows
		for (int r = 0; r < grid.length; r++) {
			List<Integer> ls = new LinkedList<>();
			for (int c = 0; c < grid[0].length; c++) {
				ls.add(grid[r][c]);
			}
			if (!map.containsKey(ls)) {
				map.put(ls, 0);
			}
			map.put(ls, map.getOrDefault(ls, 0) + 1);
		}
		
		//storing count
		int count = 0;
		
        // looping through columns
		for (int c = 0; c < grid.length; c++) {
			List<Integer> ls = new LinkedList<>();
			for (int r = 0; r < grid[0].length; r++) {
				ls.add(grid[r][c]);
			}
			if (map.containsKey(ls)) {
				count += map.get(ls);
			}

		}
		return count;

	}
}
