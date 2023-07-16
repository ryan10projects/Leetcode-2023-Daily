// Maximum Number of Events That Can Be Attended II
class Solution {
    int[][] dp;
    public int solve(int[][] events, int k, int prev, int curr, int n){
        if(k==0 || curr==n) return 0;
        
        if(dp[prev+1][k]!=-1) return dp[prev+1][k];
        
        int take=0, not_take=0;
        
        if(prev==-1 || events[prev][1]<events[curr][0]){
            take = events[curr][2] + solve(events, k-1, curr , curr+1, n);
            
       }
        
        not_take = solve(events, k, prev, curr+1, n);
        
        return dp[prev+1][k] = Math.max(take, not_take);
    }
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        dp = new int[n+1][k+1];
        Arrays.sort(events, (a,b)->{
            if(a[1]==b[1]) return a[0]-b[0];
           return a[1]-b[1];
            
        });
        for(int[] arr: dp){
        Arrays.fill(arr, -1);
        }
            
        return solve(events, k, -1, 0, n);
    }
}
