// 1406. Stone Game III
// contraints
// choice
// goal
class Solution {
public:
    int n;
    vector<int> dp;
    
    int solve(vector<int>& stoneValue, int i) {
        // constraints
        if(i == n)
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
        // pick one time and find difference
        dp[i] = stoneValue[i] - solve(stoneValue, i+1);
        // pick two time and find difference
        if(i+1 < n)
            dp[i] = max(dp[i], stoneValue[i] + stoneValue[i+1] - solve(stoneValue, i+2));
        // pick thrice and find difference
        if(i+2 < n)
            dp[i] = max(dp[i], stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - solve(stoneValue, i+3));
        // goal // memoization
        return dp[i];
    }
    
    string stoneGameIII(vector<int>& stoneValue) {
        n = stoneValue.size();
        dp.resize(n+1, -1);
        
        int diff =  solve(stoneValue, 0);
        
        if(diff < 0)
            return "Bob";
        else if(diff > 0)
            return "Alice";
        
        return "Tie";
    }
};
