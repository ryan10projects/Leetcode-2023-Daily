// 1162. As Far from Land as Possible
class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                //keep track of land
                if(grid[i][j]==1){
                    q.offer(new int[]{i,j});
                 }
             }
            
         }
        
       //if land = entire surface, there is no water
        if(q.size()==n*m){
            return -1;
        }
        int distance=0;
             //up, right, down, and left respectively
	
        int[][] dist ={{-1,0},{0,1},{1,0},{0,-1}};
        //bfs template
        while(!q.isEmpty()){
            int size = q.size();
            		//bfs is completed when it visits all the water and turns into land till then each step will have distance + 1 each iterarion to show how long it took
            distance++;
            while(size>0){
                size--;
                int[] curr = q.poll();
                //curr position x and y
                int rowcurr = curr[0];
                int colcurr = curr[1];
                for(int i=0; i<4; i++){
                    //current + direction to move
                    int row= rowcurr+dist[i][0];
                    int col = colcurr+dist[i][1];
                    		//border checking
                    if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col]==0){
                        //already visisited so mark 1
                        grid[row][col]=1;
                        q.offer(new int[]{row,col});
                        
                        }
                    
                }
                
            }
            
            
        }
            
        return distance-1;
            
    }
}
