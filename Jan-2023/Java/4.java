// 2244. Minimum Rounds to Complete All Tasks

class Solution {
	public int minimumRounds(int[] tasks) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < tasks.length; i++) {
			map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
		}
		int count = 0;
		for (int freq : map.values()) {
			if (freq < 2) {
				return -1;
			}
			if (freq % 3 != 0) {
				//(5/3)
				//5 divides by 3, 1 time and 2 remains so 1 more round
				//(11/3)
				//11/3=9, and 2 remains so one more round left
				count += (freq /= 3) + 1;
			}  else {
				//9 tasks,9/3=3 rounds
				count += (freq /= 3);
			}
		}
		return count;
	}
}
