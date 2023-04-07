// 1020. Number of Enclaves

// Algorithmn

// Turn all land connected to border to water

// dfs up, down, left, right

class Solution {

    int count=0;

    public void dfs(int[][] grid, int i, int j){

        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return;

        grid[i][j]=0;        

        dfs(grid,i+1,j);

        dfs(grid,i-1,j);

        dfs(grid,i,j+1);

        dfs(grid,i,j-1);     

    }

    

    public int numEnclaves(int[][] grid) 

    {

        for(int row=0;row<grid.length; row++){            

            if(grid[row][0]==1){

                dfs(grid,row,0);

            }

            if(grid[row][grid[0].length-1]==1){

                dfs(grid,row,grid[0].length-1);

            }                

           }        

        for(int col=0;col<grid[0].length;col++){

            if(grid[0][col]==1){

                dfs(grid,0,col);

            }

            if(grid[grid.length-1][col]==1){

                dfs(grid,grid.length-1,col);

              }          

       }                  

        for(int i=0;i<grid.length;i++){

            for(int j=0; j<grid[0].length; j++){

                if(grid[i][j]==1)                    count++;

                }

              }        

        return count;        

    }

}
