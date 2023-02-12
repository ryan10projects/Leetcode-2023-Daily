
// 2477. Minimum Fuel Cost to Report to the Capital
/*
Algorithmn
first create a basic adjency matrjx template
get the fuel by dividing the people by seats
thats how many fuel you save
if any people are remaining, you will need 1 extra fuel so add 1
and add it to the final answer,
only add it to answer if the node is 0, the goal is to reach 0 so we will not consider other paths
*/
class Solution {
    long ans = 0;

    long dfs(vector<vector<int>> &v, int node, vector<bool> &vis, int seats) {
        vis[node] = true;
        long cnt = 1;
        for (int i = 0; i < v[node].size(); i++) {
            int curr = v[node][i];
            if (!vis[curr]) {
                cnt += dfs(v, curr, vis, seats);
            }
        }
        long x = cnt / seats;
        if (cnt % seats != 0) x++;
        if (node != 0) ans += x;
        return cnt;
    }

    public:
        long minimumFuelCost(vector<vector<int>> roads, int seats) {
            if (roads.empty()) return 0;
            ans = 0;
            int n = roads.size();
            vector<vector<int>> v(n + 1);
            for (int i = 0; i < n; i++) {
                int x = roads[i][0], y = roads[i][1];
                v[x].push_back(y);
                v[y].push_back(x);
            }
            vector<bool> vis(n + 1, false);
            dfs(v, 0, vis, seats);
            return ans;
        }
};
