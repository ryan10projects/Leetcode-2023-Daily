// 1376. Time Needed to Inform All Employees
//Algorithm
// To map relationship we add adj matrix with index as the employee (value) and manager as parent (key) 
// starts from time 0
//add the time of current employee with the totaltime every recursion
// get the max time at every recursion (because all messages will already be received with lower time)

class Solution {
	int numberOfMinutes = 0;
	public void dfs(HashMap<Integer, List<Integer>> map, int[] informTime, int totalTime, int head) {
		numberOfMinutes = Math.max(numberOfMinutes, totalTime);

		for (int employee : map.getOrDefault(head, new LinkedList<>())) {
			dfs(map, informTime, totalTime + informTime[head], employee);
		}
	}
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < manager.length; i++) {
			if (manager[i] != -1) {
				if (!map.containsKey(manager[i])) {
					map.put(manager[i], new LinkedList<>());
				}
				map.get(manager[i]).add(i);
			}
		}

		dfs(map, informTime, 0, headID);
		return numberOfMinutes;

	}
}
