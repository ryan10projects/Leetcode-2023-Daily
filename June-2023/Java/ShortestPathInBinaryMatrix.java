// 1091. Shortest Path in Binary Matrix

// Bfs - Shortest Path (Storing cordinates each iteration, and increasing the level till the goal is not found)

class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        int m = grid[0].length;

        

        if(n==0 || m==0 || grid[0][0]==1) return -1;

  

        int[][] directions = {{-1,1},{1,1},{1,0},{-1,0},{0,1},{0,-1},{1,-1},{-1,-1}};

        

        Queue<Pair<Integer,Integer>> q = new LinkedList<>();

        q.add(new Pair<>(0,0));

        grid[0][0]=1;

        int levels=0;

        while(!q.isEmpty()){

            int size = q.size();

            while(size-->0){

                Pair<Integer,Integer> pair = q.poll();

                int x = pair.getKey();

                int y = pair.getValue();

                

                if(x==n-1 && y==m-1) return levels+1;

                for(int[] dir: directions){

                    int x_ = x+dir[0];

                    int y_ = y+dir[1];

                    

                    if((x_>=0 && x_<n) && (y_>=0 && y_<m) && (grid[x_][y_]==0)){

                        q.add(new Pair<>(x_,y_));

                        grid[x_][y_]=1;

                 }

                    

              }

                

            }

           levels++;

        }

        return -1;

       

    }

}
