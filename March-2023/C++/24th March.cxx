
class Solution {
public:
    int count = 0;
    void dfs(int node, int parent, vector<vector<pair<int, int>>>& adj, vector<bool>& visited) {
        visited[node] = true;
        
        for (auto& [child, sign] : adj[node]) {
            if (!visited[child]) {
                count += sign;
                dfs(child, node, adj, visited);
            }
        }
    }

    int minReorder(int n, vector<vector<int>>& connections) {
        vector<vector<pair<int, int>>> adj(n);
        for (auto& connection : connections) {
            adj[connection[0]].push_back({connection[1], 1});
            adj[connection[1]].push_back({connection[0], 0});
        }
        vector<bool> visited(n, false);
        dfs(0, -1, adj, visited);
        return count;
    }
};
