// Algorithm
// dfs traversal with cycke check is enough 
class Solution {
    public boolean dfs(Map<Integer,List<Integer>> map, Set<Integer> visited, Set<Integer> inRecursion, int u){
        visited.add(u);
        inRecursion.add(u);
        
        if(map.containsKey(u)){
        List<Integer> list  = map.get(u);
        
            for(int v: list){
            if(!visited.contains(v) && dfs(map,visited,inRecursion, v)){
                return true;         
            }
            else if(inRecursion.contains(v)){
                return true;
            }            
        }
        }
            inRecursion.remove(u);
            return false;
        }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> inRecursion = new HashSet<>();
        
        for(int i=0; i<prerequisites.length; i++){
            
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            if(!map.containsKey(u)){
                map.put(u, new LinkedList<>());
            }
            map.get(u).add(v);
        }
        
        for(int i=0; i<numCourses; i++){
            if(!visited.contains(i) && dfs(map, visited, inRecursion, i)){
                return false;
            }
        }
        return true;
    }
}
