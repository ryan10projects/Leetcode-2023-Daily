// Minimum Score of a Path Between Two Cities
// we cannot find the minimum distance in the array directly because the graph is not necessarily connected, which means that some cities might not be reachable from others. So, if we loop through the array and find the minimum distance, we might miss some cities and therefore not be able to find the minimum score of a path between cities 1 and n.

// Instead, we need to traverse the graph using a search algorithm, such as depth-first search (DFS) or breadth-first search (BFS), to find all the possible paths between cities 1 and n and calculate the minimum score of each path. This ensures that we visit all the cities and find the minimum score of a path between cities 1 and n in the entire graph.

class Solution {
    int result = Integer.MAX_VALUE;
    
    public void dfs(HashMap<Integer,List<int[]>> map, boolean[] visited, int u){
        visited[u]=true;
        for(int[] adj: map.get(u)){
            int v = adj[0];
            int w = adj[1];
            result = Math.min(result,w);
            if(!visited[v]){
           // result = Math.min(result,w);
            dfs(map,visited,v);
            }                        
        }               
    }
        
    public int minScore(int n, int[][] roads) {      
        HashMap<Integer,List<int[]>> map = new HashMap<>();
        boolean[] visited = new boolean[n+1];
        for(int i=0; i<roads.length; i++)
        {
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];
            if(!map.containsKey(u)){
                map.put(u,new LinkedList<>());
            }
            if(!map.containsKey(v)){
                map.put(v,new LinkedList<>());
            }
            map.get(u).add(new int[]{v,w});
            map.get(v).add(new int[]{u,w});            
        }
        dfs(map,visited,1);
        return result;
    }
}
