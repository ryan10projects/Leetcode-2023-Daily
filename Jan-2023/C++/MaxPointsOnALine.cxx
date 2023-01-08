// 149. Max Points on a Line

class Solution {

	public:	int maxPoints(vector<vector<int>> & points) {

		int maxPoints = 0;

		for (int i = 0; i < points.size(); i++) {

				//create new hashmap, duplicate and slope variable for each point

			unordered_map<double, int> map;

			int duplicate = 0;

			double slope = 0;

			for (int j = 0; j < points.size(); j++) {

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

				if (dx == 0) {

					slope = INT_MAX;

				} else {

					//slope would be accurate if double is used eg. 1/2=0.5 instead of 0 if integer was used

					slope = dy * 1.0 / dx;

				}

				map[slope]++;

			}

			   //found no slope

			if (map.size() == 0) {

				maxPoints = duplicate;

			} else {

					//iterate through all the values and find the maximum points that have same slope

				for (auto & i : map) {

					maxPoints = max(maxPoints, i.second + duplicate);

				}

			}

		}

		return maxPoints;

	}

};
