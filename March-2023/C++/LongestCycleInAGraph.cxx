// Longest Cycle in a Graph
// Algorithm
// First we find if there is a cycle in a directed graph
// For that we need two things
// visited array and recusrion array 
// visited array will keep track of the nodes it visits
// recursion array will check if its within the cycle loop, if it is -1 means its a dead end and recursion will  be set to false
// To find the longest cycle, if you visite the same node again. Use the formula : Total nodes - current visited node + 1
class Solution {
class Solution {
public:
    int result = -1;
    
    void dfs(int u, vector<int>& edges, vector<bool> &visited, vector<int>& dist, vector<bool> &inRecursion) {
        
        if(u != -1) {
            
            visited[u] = true;
            inRecursion[u] = true;
            
            int v = edges[u];
            
            if(v != -1 && !visited[v]) {
                
                dist[v] = dist[u] + 1;
                
                dfs(v, edges, visited, dist, inRecursion);

            } else if(v != -1 && inRecursion[v] == true) { //cycle
                
                result = max(result, dist[u] - dist[v] +1);
                
            }
        
            inRecursion[u] = false;
        }
        
    }
    
    int longestCycle(vector<int>& edges) {
        int n = edges.size();
        
        
        vector<bool> visited(n, false);
        
        vector<int> dist(n, 1);
        vector<bool> inRecursion(n, false);
        
        for(int i = 0 ; i<n; i++) {
            
            if(!visited[i]) {
                dfs(i, edges, visited, dist, inRecursion);
            }
            
        }
        
        return result;
        
    }
};
