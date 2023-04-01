// 1319. Number of Operations to Make Network Connected
// DSU
class Solution {
    int[] parent;
    int[] rank;
    
    public int find(int x){
        if(x==parent[x]){
            return x;
        }
        //optimization 
        return parent[x]=find(parent[x]);
    }
    // to reduce height of the tree, we use ranks
    public void union(int x, int y){
        int x_p = find(x);
        int y_p = find(y);
        if(x_p==y_p) return;
        if(rank[x_p]>rank[y_p]){
           parent[y_p] = x_p;
        }
        else if(rank[y_p]>rank[x_p]){
           parent[x_p] = y_p;
        }
        else{
           parent[x_p] = y_p;
           y_p++;
        }
    }
    
    public int makeConnected(int n, int[][] connections) {
        parent = new int[n];
        rank = new int[n];
        
        Arrays.fill(rank,0);
        int c = n;
        for(int i=0; i<parent.length; i++){
            parent[i]=i;
        }
        //connections are edges 
        // edges should always be one less than node
        if(connections.length<n-1) return -1;
        for(int[] node: connections){
            
       
             if(find(node[0])!=find(node[1])){
                c--;
                union(node[0],node[1]);


            }
            
            
        }
        return c-1;
    }
}
