//1129. Shortest Path with Alternating Colors

class Solution {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        List<List<int[]>> adj= new ArrayList<>();

        for(int i=0; i<n; i++){

            adj.add(new ArrayList<>());

        }

        //creating a normal adjency matrix but adding the color to keep track of previous color, so hence we will use int array 

        

        //0 for red

        for(int[] edge: redEdges){

            adj.get(edge[0]).add(new int[]{edge[1],0});

        }

        //1 for blue

        for(int[] edge: blueEdges){

            adj.get(edge[0]).add(new int[] {edge[1],1});

        }

        //unvisited array will have -1 as default distance

        int[] ans = new int[n];

        Arrays.fill(ans,-1);

        //first node will always have distance 0 to itself

        ans[0]=0;

        boolean[][] visited = new boolean[n][2];

        //we will store node and the color, if we have visited the node with color we will return, and since we are using bfs, we will always get the minimum steps 

        Queue<int[]> queue= new LinkedList<>();

        //we will start traversing the starting node from both the color since the previous color of 0 can be blue or red

        visited[0][0]=true;

        visited[0][1]=true;

        // we store the node, distance and previous node color which is -1 (no color)

        queue.offer(new int[]{0,0,-1});

        while(!queue.isEmpty()){

            int[] curr = queue.poll();

            int node = curr[0], steps=curr[1], prevColor=curr[2];

            for(int[] neighbour: adj.get(node)){

                int nextNode = neighbour [0], color=neighbour[1];

                if(!visited[nextNode][color] && color!=prevColor){

                    visited[nextNode][color]=true;

                   queue.offer(new int[]{nextNode,steps+1,color});

                    //since it is using bfs, we will always get the smallest distance so we only check if is -1 if the distance was never updated at all

                    if(ans[nextNode]==-1){

                        ans[nextNode]=steps+1;

                        }

               }

           }

        }

        return ans;

    }

}
