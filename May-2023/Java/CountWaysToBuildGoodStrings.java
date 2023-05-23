//Algorithm 
// Constraint (be within range)
// Choice (add zero or add one)
// Goal (if within range add 1)

// 2466. Count Ways To Build Good Strings
class Solution {
    int L;
    int H;
    int Z;
    int O;
    int[] dp;
    int mod = 1000000007;
    public int solve(int length){
        if(length>H) return 0;
        if(dp[length]!=-1) return dp[length];
        int ans = 0;
        if(length>=L && length<=H){
            ans=1;
        }
                       
        int ones = solve(length+O);
        int zeroes = solve(length+Z);
        return dp[length]=((ans%mod)+(ones%mod)+(zeroes%mod))%mod;        
    }
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        this.L=low;
        this.H=high;
        this.Z=zero;
        this.O=one;
        dp = new int[high+1];
        Arrays.fill(dp,-1);
        return solve(0);
            
    }
}
