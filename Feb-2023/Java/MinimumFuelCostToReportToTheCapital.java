
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
    long answer =0;
    public long dfs(List<List<Integer>> adj, int node, boolean[] visited, int seats)
    {
        int count=1;
        int curr = node;
        visited[node]=true;
        for(int i=0; i<adj.get(curr).size();i++){
            int neighbour = adj.get(curr).get(i);
            if(!visited[neighbour]){
                count+=dfs(adj,neighbour,visited,seats);
            }
            }
            
            long fuel = count/seats;
            if(count%seats!=0) fuel++;
            if(curr!=0){answer=answer+=fuel;}
                        
            
            
        
        
        return count;
        
    }
    
    public long minimumFuelCost(int[][] roads, int seats) {
        if(roads.length==0) return 0;
        int n = roads.length;
        List<List<Integer>> adj = new ArrayList<>(n+1);
        for(int i=0; i<=n; i++){
            
            adj.add(new ArrayList<>());
            
        }
        
        for(int i=0; i<n; i++){
            
            int x = roads[i][0];
            int y = roads[i][1];
            adj.get(x).add(y);
            adj.get(y).add(x);
        
        }
        
        boolean[] visited = new boolean[n+1];
        dfs(adj,0,visited,seats);
        return answer;
    }
}
