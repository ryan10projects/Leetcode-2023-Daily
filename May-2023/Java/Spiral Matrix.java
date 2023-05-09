class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        if(matrix.length==0) return res;
        
        int rowStart=0;
        int rowEnd=matrix.length-1;
        int columnStart=0;
        int columnEnd= matrix[0].length-1;
        
        while(rowStart<=rowEnd && columnStart<=columnEnd){
         for(int i=columnStart;i<=columnEnd;i++){
             res.add(matrix[rowStart][i]);
             
             }
            
            rowStart++;
            
            for(int i=rowStart;i<=rowEnd;i++){
                res.add(matrix[i][columnEnd]);
                }
                columnEnd--;
            
            
            if(rowStart<=rowEnd){
                
                for(int i=columnEnd;i>=columnStart;i--){
                    res.add(matrix[rowEnd][i]);
                    }
                
                }
            rowEnd--;
                
            if(columnStart<=columnEnd){
                for(int i=rowEnd;i>=rowStart;i--){
                    res.add(matrix[i][columnStart]);
                    
                    }
                }
                columnStart++;
                
                
                }
            
            
            
             
         
            
            

    return res;
    }
}
