/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// 133. Clone Graph
// Algorithmn
// Use a HashMap to store the original node as key and value will be the clone
// constant time insertion, deletion
// 
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        return dfs(map,node);
        }
       public Node dfs(HashMap<Node,Node> map, Node n){
           if(map.containsKey(n)) return map.get(n.val);          
              Node copy = new Node(n);
              map.put(n,copy);
           //map original node as key and vopy as value
              for(Node nei:n.neighbors){
      

 copy.neighbors.add(dfs(map,nei));
                  }
              return copy;           
           }      
    }
