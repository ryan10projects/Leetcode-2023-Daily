// 714. Best Time to Buy and Sell Stock with Transaction Fee
// two choices 
// after selling reduce the fee
class Solution {
    int[][] dp;
    int FEE;
    public int solve(int[] prices, int day, int buy){
        
        if(day>= prices.length) return 0;
        if(dp[day][buy]!=-1) return dp[day][buy];
        int profit =0;
        if(buy==0){
            int consider = solve(prices,day+1,1)-prices[day];
            int not_consider = solve(prices, day+1, 0);
            profit = Math.max(profit,Math.max(consider,not_consider));
        }
        else{
            int consider = solve(prices,day+1,0)+prices[day]-FEE;
            int not_consider = solve(prices,day+1,1);
            profit = Math.max(profit, Math.max(consider,not_consider));
        }
        
        return dp[day][buy]=profit;
        
    }
    
    public int maxProfit(int[] prices, int fee) {
        FEE = fee;
        dp = new int[prices.length][2];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        return solve(prices,0,0);
        
    }
}
