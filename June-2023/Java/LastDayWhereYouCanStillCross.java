// 1970. Last Day Where You Can Still Cross
// Algorithm
// mix of binary search and dfs traversal
// use binary search on the days
// mark up all the water till the mid
// if we can reach the last row despite all the water, we move left=mid+1, and all the days before that can be added
// otherwise vice versa
class Solution {
    int ROW;
    int COL;
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public boolean dfs(int i, int j, int[][] visited){
        if(i<0 || i>=ROW || j<0 || j>=COL || visited[i][j]==1){
         return false;   
       }
        
       if(i==ROW-1){
           return true;
       }
        
       visited[i][j]=1;
        
       for(int[] directions: dir){
           
           int i_ = i + directions[0];
           int j_ = j+ directions[1];
           
           if(dfs(i_,j_,visited)){
               return true;
            }
          
       }
       return false;
     }   
        
        
    
    
    public boolean canCross(int[][] cells, int mid){
        int[][] visited = new int[ROW][COL];
        for(int i=0; i<=mid; i++){
          int r = cells[i][0]-1;
          int c = cells[i][1]-1;
          visited[r][c] = 1;
        }
        
        for(int j=0; j<COL; j++){
        if(visited[0][j]==0 && dfs(0,j, visited)){
            return true;
         }
        }
        return false;
    }
    
    public int latestDayToCross(int row, int col, int[][] cells) {
        this.ROW = row;
        this.COL = col;
        int left = 0;
        int right = cells.length-1;
        int latestDay = 0;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(canCross(cells, mid)){
                latestDay = mid+1;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return latestDay;
    }
}
