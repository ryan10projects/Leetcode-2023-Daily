/*
787. Cheapest Flights Within K Stops
Outer loop is to select atmost K stops
Inner loop selects the minimum path (Classic Bellman ford algorithm)
C++
*/

class Solution {
	public:
	int findCheapestPrice(int n, vector<vector<int>> & flights, int src, int dst, int K) {
	vector<int> dist(n, INT_MAX);
	dist[src] = 0;
	for (int i = 0; i <= K; i++) {
		vector<int> temp = dist;
		for (auto & i : flights) {
			if (dist[i[0]] != INT_MAX) {
				temp[i[1]] = min(temp[i[1]], dist[i[0]] + i[2]) }}
			dist = temp;
		}
		return dist[dst] == INT_MAX ? -1 : dist[dst];
	}
};
