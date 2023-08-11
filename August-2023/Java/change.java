class Solution {
    int[][] dp;
    public int solve(int amount, int[] coins, int index){
         if(amount==0) return 1;
         if(index==coins.length) return 0;
        if(dp[amount][index]!=-1) return dp[amount][index];
        
         if(coins[index]>amount) return dp[amount][index]=solve(amount, coins, index+1);
        
        
        int take = solve(amount-coins[index], coins, index);
        int not_take = solve(amount,coins,index+1);
        return dp[amount][index]=take+not_take;
    }
    public int change(int amount, int[] coins) {
        dp= new int[5001][301];
        for(int[] arr:dp) Arrays.fill(arr,-1);
        return solve(amount,coins,0);
        

    }
}
