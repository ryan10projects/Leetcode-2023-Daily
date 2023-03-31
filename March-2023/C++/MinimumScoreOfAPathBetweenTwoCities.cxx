//Minimum Score of a Path Between Two Cities
// we cannot find the minimum distance in the array directly because the graph is not necessarily connected, which means that some cities might not be reachable from others. So, if we loop through the array and find the minimum distance, we might miss some cities and therefore not be able to find the minimum score of a path between cities 1 and n.
// Instead, we need to traverse the graph using a search algorithm, such as depth-first search (DFS) or breadth-first search (BFS), to find all the possible paths between cities 1 and n and calculate the minimum score of each path. This ensures that we visit all the cities and find the minimum score of a path between cities 1 and n in the entire graph.
class Solution {
public:

    void dfs(unordered_map<int, vector<pair<int, int>>> &adj, int u, vector<bool>& visited, int &result) {
        
        visited[u] = true;
        
        for(auto &vec : adj[u]) {
            int v = vec.first;
            int c = vec.second;
            
            result = min(result, c);
            
            if(!visited[v]) {
                dfs(adj, v, visited, result);
            }
        }
    }
    
    int minScore(int n, vector<vector<int>>& roads) {
        unordered_map<int, vector<pair<int, int>>> adj;
        
        for(auto &vec : roads) {
            
            int u = vec[0];
            int v = vec[1];
            int c = vec[2];
            
            adj[u].push_back({v, c});
            adj[v].push_back({u, c});
        }
        
        vector<bool> visited(n, false);
        int result = INT_MAX;
        dfs(adj, 1, visited, result);
        
        return result;
    }
};
