//1129. Shortest Path with Alternating Colors
class Solution {
	public:
	vector<int> shortestAlternatingPaths(int n, vector<vector<int>> & redEdges, vector<vector<int>> & blueEdges) {
		vector<vector<pair<int, int>>> adj(n);
		 //creating a normal adjency matrix but adding the color to keep track of previous color, so hence we will use int array 
        
        //0 for red
		for (auto & edge : redEdges) {
			adj[edge[0]].push_back({edge[1], 0});
		}
		 //1 for blue
		for (auto & edge : blueEdges) {
			adj[edge[0]].push_back({edge[1], 1});
		}
        	//unvisited array will have -1 as default distance
		vector<int> ans(n, -1);
		  //we will store node and the color, if we have visited the node with color we will return, and since we are using bfs, we will always get the minimum steps 
		vector<vector<bool>> visited(n, vector<bool>(2));

  	queue<vector<int>> q;
		// we store the node, distance and previous node color which is -1 (no color)
		q.push({0, 0, -1});
	  //we will start traversing the starting node from both the color since the previous color of 0 can be blue or red
		visited[0][0] = true;

		visited[0][1] = true;
	      //first node will always have distance 0 to itself
		ans[0] = 0;

		while (!q.empty()) {
			vector<int> curr = q.front();
			q.pop();
			int node = curr[0], steps = curr[1], prevColor = curr[2];

			for (auto & neighbor : adj[node]) {

				int nextNode = neighbor.first, color = neighbor.second;

				if (!visited[nextNode][color] && color != prevColor) {

					visited[nextNode][color] = true;
					q.push({nextNode, steps + 1, color});
					 //since it is using bfs, we will always get the smallest distance so we only check if is -1 if the distance was never updated at all
					if (ans[nextNode] == -1) {
						ans[nextNode] = steps + 1;
					}
				}
			}
		}
		return ans;
	}
};
