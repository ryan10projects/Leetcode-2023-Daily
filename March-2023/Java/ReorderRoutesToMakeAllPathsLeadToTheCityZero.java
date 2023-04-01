// Reorder Routes to Make All Paths Lead to the City Zero
// Algorithm
// Add the count of directed nodes starting from 0 only
class Solution {
    int ans=0;
    boolean[] visited;
    public void dfs(int u, HashMap<Integer,List<int[]>> map){
        visited[u]=true;
        for(int[] arr: map.get(u)){
            int v = arr[0];
            int d = arr[1];
            if(!visited[v]){
                if(d==1){
                    ans++;
                }
                dfs(v,map);               
           }          
        }
    }
          
    public int minReorder(int n, int[][] connections) {
        visited = new boolean[n];
        HashMap<Integer,List<int[]>> map = new HashMap<>();
        for(int[] arr: connections){
            int u = arr[0];
            int v = arr[1];
            if(!map.containsKey(u)){
                map.put(u, new LinkedList<>());
            }
            if(!map.containsKey(v)){
               map.put(v, new LinkedList<>());
            }
            map.get(u).add(new int[]{v,1});
            map.get(v).add(new int[]{u,0});
              
            
        }
        dfs(0,map);
        return ans;
    }
}
