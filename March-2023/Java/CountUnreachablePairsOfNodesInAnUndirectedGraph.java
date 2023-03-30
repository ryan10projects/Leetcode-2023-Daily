// Count Unreachable Pairs of Nodes in an Undirected Graph
// Algorithm
// find count of all the nodes in a group
// formula 
// count of all nodes in a group * remainingSize (remove duplicate)/2
class Solution {
    void dfs(int u, Map<Integer, List<Integer>> adj, boolean[] visited, long[] sizeOfComponent) {
        visited[u] = true;
        // neighbour found increment count of nodes together
        sizeOfComponent[0]++;
        if (adj.get(u) == null) return;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited, sizeOfComponent);
            }
        }
    }

    long countPairs(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        long result = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // array for pass by reference
                // normal long will create a copy and not save the state
                // size is initialised everytime neighbor is not found and the i increments looking for neighbors of next node
                long[] sizeOfComponent = new long[1];
                dfs(i, adj, visited, sizeOfComponent);
                result += (sizeOfComponent[0]) * (n - sizeOfComponent[0]);
            }
        }

        return result / 2;
    }
}
