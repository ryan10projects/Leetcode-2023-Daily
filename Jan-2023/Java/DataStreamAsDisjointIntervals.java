// 352. Data Stream as Disjoint Intervals
/* we need to add all the numbers in an ordered set which makes it sorted, and add all the numbeds in the set that form a valid range 1,2,3,5,6 so here {1,3} {5,6} is a valid set */
class SummaryRanges {
	Set<Integer> set;
	public SummaryRanges() {
		set = new HashSet<>();
	}
	public void addNum(int value) {
		set.add(value);
	}
	public int[][] getIntervals() {
		List<Integer> nums = new LinkedList<>(set);
		Collections.sort(nums);
		List<List<Integer>> ls = new LinkedList<>();
		for (int i = 0; i < nums.size(); i++) {
			//get left number
			int left = nums.get(i);
			while (i < nums.size() - 1 && nums.get(i) + 1 == nums.get(i + 1)) {
				//get right numbef
				i++;
			}
			//add left and right number range
      	ls.add(Arrays.asList(left, nums.get(i)));
		}
		//convert list of list of integer to int[][]
		//set row size
		int[][] arr = new int[ls.size()][];
		for (int i = 0; i < ls.size(); i++) {
			List<Integer> innerlist = ls.get(i);
			//set column size
			arr[i] = new int[innerlist.size()];
			for (int j = 0; j < innerlist.size(); j++) {
				arr[i][j] = innerlist.get(j);
			}
		}
		return arr;

	}
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
