
// 839. Similar String Groups
// 3 steps
// First make the adjency nodes map within the numSimilarGroups function, only if isSimilar is true
// Second implement isSimilar function at most only two or zero letters in both the string should be different to be considered similar
// Traditional dfs traversal marking all visited, if it returns that means it has finished traversing one level and you have found one group
class Solution {
public:
    
    bool isSimilar(string &s1, string &s2) {
        
        int n = s1.length();
        int diff = 0;
        for(int i = 0; i<n; i++) {
            if(s1[i] != s2[i])
                diff++;
        }
        
        
        return diff == 2 || diff == 0;
    }
    
    void DFS(int u, unordered_map<int, vector<int>> &adj, vector<bool>& visited) {
        visited[u] = true;
        
        for(int &v : adj[u]) {
            if(!visited[v])
                DFS(v, adj, visited);
        }
    }
    
    int numSimilarGroups(vector<string>& strs) {
        
        int n = strs.size();
        
        unordered_map<int, vector<int>> adj;
        for(int i = 0; i<n; i++) {
            for(int j = i+1; j<n; j++) {
                if(isSimilar(strs[i], strs[j])) {
                    adj[i].push_back(j);
                    adj[j].push_back(i);
                }
            }
        }
        
        vector<bool> visited(n, false);
        int count = 0;
        
        for(int i = 0; i<n; i++) {
            if(!visited[i]) {
                DFS(i, adj, visited);
                count++;
            }
        }
        
        return count;
    }
};
