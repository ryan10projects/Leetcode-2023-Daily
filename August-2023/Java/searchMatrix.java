class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        
        int rowL = matrix.length;
        int columnL = matrix[0].length;
        int row=rowL-1;
        int col=0;
        
            while(row>=0 && col<columnL){
            int curr = matrix[row][col];
            if(curr==target) return true;
            if(curr>=target){
                row--;
             }
            else{
                col++;
                }
         }
        return false;
    }
}
