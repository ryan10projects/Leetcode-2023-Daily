class Solution {
    int n;
    int[][][] dp;
    public int solve(int[] piles, int person, int i, int maxpiles){
        
        if(i>=n) return 0;
        
        if(dp[person][i][maxpiles]!=-1) return dp[person][i][maxpiles];
        
        int result = (person==1)?-1:Integer.MAX_VALUE;
        
        int stones = 0;
        
        for(int x=1; x<=Math.min(2*maxpiles,n-i); x++){
            
            stones+=piles[i+x-1];
            
            if(person==1){
                
                result = Math.max(result,stones+solve(piles,0,i+x,Math.max(maxpiles,x)));
                                  
             
                    
            }  
            else{
                result = Math.min(result,solve(piles,1,i+x,Math.max(maxpiles,x)));
                
           }
            
            
            
            
      }
        return dp[person][i][maxpiles]=result;
     }   
        
    
    
    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new int[2][n+1][n+1];
        for(int[][] arr: dp){
            for(int[] i: arr){
                Arrays.fill(i,-1);
            }
        }
        return solve(piles,1,0,1);

        
    }
}
