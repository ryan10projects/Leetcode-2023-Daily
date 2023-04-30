 // 1579. Remove Max Number of Edges to Keep Graph Fully Traversable
 class DSU{

 public:

    vector<int> parent;

    vector<int> rank;

    int components;

    

    DSU(int n){

        // node starts from 1

        parent.resize(n+1);

        rank.resize(n+1);

        components=n;

    



    for(int i=0; i<parent.size(); i++){

        parent[i]=i;

    }
   }
        

    

    int find(int x){

        if(x==parent[x]) return x;

        return parent[x]=find(parent[x]);

    }

    

    void Union(int x, int y){

        int xp=find(x);

        int yp=find(y);

        if(xp==yp) return;

        if(rank[xp]>=rank[yp]){

            parent[yp]=xp;

        }

        else if(rank[yp]<=rank[xp]){

            parent[xp]=yp;

        }

        else{

           parent[xp]=yp;

           rank[yp]++;

        }

        components--;

    }

     

    bool isValid(){

        if(components==1) return true;

        return false;

    }

    

};

  

 

    

class Solution {

public:

    int maxNumEdgesToRemove(int n, vector<vector<int>>& edges) {

        DSU Alice(n);

        DSU Bob(n);

        

    auto lambda = [](vector<int>&v1, vector<int>&v2){

        return v1[0]>v2[0];

        

     };

        

    sort(begin(edges),end(edges),lambda);

        int edgeCount=0;

        for(auto& v: edges){

            int edge = v[0];

            int a = v[1];

            int b = v[2];

            if(edge==3){

                bool edgeAdded = false;

                if(Alice.find(a)!=Alice.find(b)){

                   Alice.Union(a,b);

                   edgeAdded=true;

                 }

                

                if(Bob.find(a)!=Bob.find(b)){

                    Bob.Union(a,b);

                    edgeAdded=true;           }

                

                if(edgeAdded==true){

                    edgeCount++;

                }

              }else if(edge==2){

                if(Alice.find(a)!=Alice.find(b)){

                    Alice.Union(a,b);

                    edgeCount++;

                }

                

                

            }

            else{

                if(Bob.find(a)!=Bob.find(b)){

                    Bob.Union(a,b);

                    edgeCount++;

                        

               }

            }

                

                

            

            

        }

        if(Alice.isValid()== true && Bob.isValid()==true){

            return edges.size()-edgeCount;

        }

        return -1;

    }

};
