// 1162. As Far from Land as Possible
class Solution {
	public:
	int maxDistance(vector<vector<int>> & grid) {
		int n = grid.size();
		int m = grid[0].size();
		queue<pair<int, int>> q;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				//keep track of land
				if (grid[i][j] == 1) {
					q.push({i, j});
				}
			}
		}
       //if land = entire surface, there is no water
		if (q.size() == n * m) {
			return -1;
		}

		int dist = 0;
        //up, right, down, and left respectively
		int d[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        //bfs template
		while (!q.empty()) {
			int size = q.size();
			//bfs is completed when it visits all the water and turns into land till then each step will have distance + 1 each iterarion to show how long it took
			dist++;
			while (size-- > 0) {
				pair<int, int> curr = q.front();
				q.pop();
				int si = curr.first;
				int sj = curr.second;
				for (int i = 0; i < 4; i++) {
					//current + direction to move
					int row = si + d[i][0];
					int col = sj + d[i][1];
					//border checking
					if (row >= 0 && row < grid.size() && col >= 0 && col < grid[0].size() && grid[row][col] == 0) {
						q.push({row, col});
						//already visited so mark 1
						grid[row][col] = 1;
					}
				}

			}
		}
		return dist - 1;
	}
};
