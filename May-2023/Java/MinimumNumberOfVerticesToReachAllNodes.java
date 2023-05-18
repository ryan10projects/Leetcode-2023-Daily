// 1557. Minimum Number of Vertices to Reach All Nodes
// save only indegree nodes
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
       List<Integer> result = new LinkedList<>();
       boolean[] nodes = new boolean[n];
       for(List<Integer> i: edges){
            nodes[i.get(1)]=true;
        }
    for(int i=0; i<nodes.length; i++){
      if(nodes[i]==false) result.add(i);
       }
     return result;
    }
}
