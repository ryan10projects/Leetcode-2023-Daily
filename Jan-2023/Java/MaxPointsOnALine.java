// 149. Max Points on a Line
class Solution {
	public int maxPoints(int[][] points) {
		int maxPoints = 0;
		for (int i = 0; i < points.length; i++) {
			//create new hashmap, duplicate and slope variable for each point
			HashMap<Double, Integer> map = new HashMap<>();
			int duplicate = 0;
			double slope = 0;
			for (int j = 0; j < points.length; j++) {
				int x1 = points[i][0];
				int y1 = points[i][1];
				int x2 = points[j][0];
				int y2 = points[j][1];
				int dx = x2 - x1;
				int dy = y2 - y1;
				if (dx == 0 && dy == 0) {
					duplicate++;
					continue;
				}
				//cannot divide by 0
				if (dx != 0) {
					//slope would be accurate if double is used eg. 1/2=0.5 instead of 0 if integer was used
					slope = dy * 1.0 / dx;
				} else {
					slope = Integer.MAX_VALUE;
				}
				map.put(slope, map.getOrDefault(slope, 0) + 1);
			}
			//found no slope
			if (map.size() == 0) {
				maxPoints = duplicate;
			} else {
				//iterate through all the keys and find the maximum points that have same slope
				for (double s : map.keySet()) {
					maxPoints = Math.max(maxPoints, map.get(s) + duplicate);

				}

			}
		}

		return maxPoints;
	}
}
