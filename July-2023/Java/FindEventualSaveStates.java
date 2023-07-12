// Algorithm
// similar to detect cycle in graph but here we only return the not recursive nodes 
class Solution {
    public boolean dfs(int[][] graph, Set<Integer> visited, Set<Integer> inRecursion, int u){
        visited.add(u);
        inRecursion.add(u);
        
        for(int v: graph[u]){
            if(!visited.contains(v) && dfs(graph,visited,inRecursion, v)){
                return true;
            }
            else if(inRecursion.contains(v)){
                return true;
             }
          
        }
        
        inRecursion.remove(u);
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> inRecursion = new HashSet<>();
        List<Integer> list = new LinkedList<>();
      for(int i=0; i<graph.length; i++){
          if(!visited.contains(i)){
              dfs(graph,visited,inRecursion,i);
          }
       }
        
        for(int i=0; i<visited.size(); i++){
            if(!inRecursion.contains(i)){
                list.add(i);
            }
        }
            return list;
    }
}
