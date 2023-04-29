// 1697. Checking Existence of Edge Length Limited Paths

// Algorithm 

// set the index of edges array so we can add the results in order, then sort edges and queries based on distance

// we sort them based on distance because we dont have to create unions, once we have already created groups for them, so the next query in queries doesnt have to delete links between the nodes

// suppose a query with distance 2 and another query with distance 5 exists, we wont have to create groups for distance 5, since it was already formed while forming groups with distance 2. this reduces the time complexity by a great margin compared to dfs/bfs

class Solution {

    

    private int[] parent;

    private int[] rank;

    

    private int find(int x) {

        if(parent[x] != x) {

            parent[x] = find(parent[x]);

        }

        return parent[x];

    }

    

    private void Union(int x, int y) {

        int x_parent = find(x);

        int y_parent = find(y);

        

        if(x_parent != y_parent) {

            if(rank[x_parent] > rank[y_parent]) {

                parent[y_parent] = x_parent;

            }

            else if (rank[y_parent] > rank[x_parent]) {

                parent[x_parent] = y_parent;

            }

            else {

                parent[x_parent] = y_parent;

                rank[y_parent]++;

            }

        }                

    }

    

    

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        

        this.parent = new int[n];

        this.rank = new int[n];

        

        

        for(int i=0; i<n; i++) {

            parent[i] = i;

        }

        

        for (int i = 0; i < queries.length; i++) {

            queries[i] = new int[] { queries[i][0], queries[i][1], queries[i][2], i };

        }



        Arrays.sort(queries, (a, b) -> Integer.compare(a[2], b[2]));

        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));

        

        boolean result[] = new boolean[queries.length];

        

        int j =0;

        for(int i=0; i<queries.length; i++) {

            

            int query[] = queries[i];

            

            int u = query[0];

            int v = query[1];

            int t = query[2];

            int idx = query[3];

            

            while(j < edgeList.length && edgeList[j][2] < t) {

                Union(edgeList[j][0], edgeList[j][1]);

                j++;

            }

            

            

            if(find(u) == find(v)) {

                result[idx] = true;

            }

            else {

                result[idx] = false;

            }

        }

        

        return result;

        

    }

}}
