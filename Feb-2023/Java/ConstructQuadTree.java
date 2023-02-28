// 427. Construct Quad Tree
class Solution {
    public boolean isSame(int[][] grid, int x, int y, int n){
        int value = grid[x][y];
       // Check if the value in the box of the current quadrant is same, otherwise divide it into 4 blocks
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n;j++){
                if(grid[i][j]!=value) return false;
                
              }
            
        }
        
        return true;
    }
    public Node solve(int[][]grid, int x, int y, int n){
        if(isSame(grid,x,y,n)){
            // If value is not 0 make it true(according to the question)
            return new Node(grid[x][y]!=0,true);
            
        }
           else{
              //Recursively call each quadrant, make current node false and add a random value
               Node root = new Node(true,false);
               root.topLeft = solve(grid,x,y,n/2);
               root.topRight=solve(grid,x,y+n/2,n/2);
               root.bottomLeft=solve(grid,x+n/2,y,n/2);
               root.bottomRight=solve(grid,x+n/2,y+n/2,n/2);
               return root;
            }
    }
    public Node construct(int[][] grid) {
        return solve(grid,0,0,grid.length);
    }
} 
