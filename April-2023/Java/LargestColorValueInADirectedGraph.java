// 1857. Largest Color Value in a Directed Graph
// Algorithm
// Topological traversal
// Consider the nodes with only indegree of 0 and keep pushing them in queue
// Reduce the child indegree to -1 after every time the child is visited while traversing the parents children
// In the second math.max check if current path color count is greater in matrix or parents+current
// If the count of nodes is less than colors.length(number of nodes) it meets all nodes couldn't be visited since there is a loop
// Difficulty hard
// The time complexity of the provided Java code is O(N + E), where N is the number of nodes (length of the colors string) and E is the number of edges in the graph represented by the edges array. The code performs a topological sort using BFS and visits each node and each edge once. Inside the BFS loop, there is another loop that iterates over each color (26 colors) for each neighbor of the current node. However, the maximum number of iterations of this inner loop is bounded by the number of colors, which is constant (26), so it does not increase the time complexity.Therefore, the overall time complexity of the code is O(N + E), which is linear in the size of the input graph.
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[colors.length()];
        for(int[] i: edges){
            int u = i[0];
            int v = i[1];
            if(!adj.containsKey(u)){
              adj.put(u, new LinkedList<>());
            }
            indegree[v]++;
            adj.get(u).add(v);
        }
        int[][] mat = new int[colors.length()][26];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0){
                q.add(i);
            
            mat[i][colors.charAt(i)-'a']=1;
            }
       }
        //keep track of nodes, if nodes<colors. There is a loop
        int count=0;
        int answer = 0;
        //bfs 
        while(!q.isEmpty()){
            int parent = q.poll();
            count++;
            answer = Math.max(answer,mat[parent][colors.charAt(parent)-'a']);
            if(adj.containsKey(parent)){
            for(int v: adj.get(parent))
            {
                // check all colors highest 
              for(int i=0; i<26; i++){
                 // if((colors.charAt(v)-'a')==i){
                mat[v][i]=Math.max(mat[v][i], mat[parent][i]+((colors.charAt(v)-'a')==i?1:0));
               
               
            }
            indegree[v]--;
            if(indegree[v]==0){
                q.add(v);
            }
            
            
         }
            }
        
        }
        if(count<colors.length()) return -1;
          
            
        return answer;
    }
}
