// 1697. Checking Existence of Edge Length Limited Paths

// Algorithm 

// set the index of edges array so we can add the results in order, then sort edges and queries based on distance

// we sort them based on distance because we dont have to create unions, once we have already created groups for them, so the next query in queries doesnt have to delete links between the nodes

// suppose a query with distance 2 and another query with distance 5 exists, we wont have to create groups for distance 5, since it was already formed while forming groups with distance 2. this reduces the time complexity by a great margin compared to dfs/bfs

class Solution {

public:

    vector<int> parent;

    vector<int> rank;

   

    int find(int x){

        if(x==parent[x]){

            return x;

        }

        return parent[x]=find(parent[x]);

    }

    

    void Union(int x, int y){

        int xp = find(x);

        int yp = find(y);

        if(xp==yp) return;

        if(rank[xp]>rank[yp]){

            parent[yp]=xp;

        }else if(rank[xp]<rank[yp]){

            parent[xp]=yp;

        }

        else{

            parent[xp]=yp;

            rank[yp]++;

        }

        

    }

    

    vector<bool> distanceLimitedPathsExist(int n, vector<vector<int>>& edges, vector<vector<int>>& queries) {

        

        parent.resize(n);

        

        rank.resize(n);

        

        for(int i=0; i<n; i++){

            parent[i]=i;

        }

        

        auto lambda = [&](vector<int>& v1,vector<int>&v2){

            return v1[2]<v2[2];

        };

        for(int i=0; i<queries.size(); i++){

            queries[i].push_back(i);

      }

 sort(begin(edges),end(edges),lambda);

 sort(begin(queries),end(queries),lambda);

       

        vector<bool> result;

        result.resize(queries.size());

        int j=0;

        for(int i=0; i<queries.size(); i++){

            vector<int> q = queries[i];

            int u = q[0];

            int v = q[1];

            int t = q[2];

            int ind = q[3];

            while(j<edges.size() && edges[j][2]<t){

                Union(edges[j][0],edges[j][1]);

                j++;

            }

            

            int x = find(u);

            int y = find(v);

            if(x==y){

                result[ind]=true;

            }

            else{

                result[ind]=false;

            }            

      }        

        return result;

        

    }

};
