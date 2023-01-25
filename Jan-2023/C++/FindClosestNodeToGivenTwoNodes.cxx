// 2359. Find Closest Node to Given Two Nodes

class Solution {

	public:	int closestMeetingNode(vector<int> & edges, int node1, int node2) {

		vector<int> distance1;

		//initially all the nodes have distance -1, assuming they didnt visit any node

		distance1.resize(edges.size(), -1);

		vector<int> distance2;

		distance2.resize(edges.size(), -1);

		int result = -1;

		vector<bool> visited1;

		visited1.resize(edges.size(), false);

		vector<bool> visited2;

		visited2.resize(edges.size(), false);

		dfs(edges, distance1, node1, visited1, 0);

		dfs(edges, distance2, node2, visited2, 0);

		int max1 = INT_MIN;

		int min1 = edges.size();

		for (int i = 0; i < edges.size(); i++) {

			//to check if both nodes did not faile to visit a node

			//if they are -1, it means it didnt find any path to the node

			if (distance1[i] != -1 && distance2[i] != -1) {

				max1 = max(distance1[i], distance2[i]);

				if (max1 < min1) {

					// minimum of the maximum distance as per the question

					min1 = max1;

					  //return the node value with minimum of maximum distance

					result = i;

				}

			}

		}

		return result;

	}

	void dfs(vector<int> & edges, vector<int> & distance1, int node, vector<bool> & visited, int distance) {

		  //if -1 there is no path to be visited

		if (node != -1 && visited[node] == false) {

			visited[node] = true;

			distance1[node] = distance;

			dfs(edges, distance1, edges[node], visited, distance + 1);

		}

	}

};
