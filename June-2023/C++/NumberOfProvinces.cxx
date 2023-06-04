// 547. Number of Provinces
// simple dfs
class Solution {
    int count = 0;

    void dfs(unordered_map<int, list<int>>& map, unordered_set<int>& visited, int u) {
        if (visited.count(u)) return;
        for (int v : map[u]) {
            if (!visited.count(v)) {
                visited.insert(u);
                dfs(map, visited, v);
            }
        }
    }

public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        unordered_map<int, list<int>> map;
        for (int i = 0; i < isConnected.size(); i++) {
            for (int j = 0; j < isConnected[0].size(); j++) {
                if (isConnected[i][j] == 1) {
                    if (map.find(i) == map.end()) {
                        map[i] = list<int>();
                    }
                    map[i].push_back(j);
                }
            }
        }
        unordered_set<int> visited;
        for (int i = 0; i < isConnected.size(); i++) {
            if (!visited.count(i)) {
                dfs(map, visited, i);
                count++;
            }
        }
        return count;
    }
};
