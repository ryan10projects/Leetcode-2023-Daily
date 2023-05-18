// 1557. Minimum Number of Vertices to Reach All Nodes
// save only indegree nodes
class Solution {
public:
    vector<int> findSmallestSetOfVertices(int n, vector<vector<int>>& edges) {
        vector<int> result;
        vector<bool> nodes(n, false);
        for (vector<int>& i : edges) {
            nodes[i[1]] = true;
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (!nodes[i]) {
                result.push_back(i);
            }
        }
        return result;
    }
};
