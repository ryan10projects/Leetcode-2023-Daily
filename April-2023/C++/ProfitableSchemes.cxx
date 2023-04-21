// 879. Profitable Schemes
// algorithm
// Pick current group of people or go to next group and pick them, this will be done using taken and not taken, if I reache the end of group length, this means we saw all the possibilities and will return 1 if true and a group satisfies the minProfit condition 
class Solution {
public:
    int t[101][101][101];

    int thresholdProfit;
    int N;
    const int MOD = 1e9+7;
    
    int solve(int i, int p, int people, vector<int>& group, vector<int>& profit) {
        if(people > N)
            return 0;
        
        if(i == group.size()) {
            if(p >= thresholdProfit)
                return t[i][p][people] = 1;
            return t[i][p][people] = 0;
        }
        
        if(t[i][p][people] != -1)
            return t[i][p][people];
        
        long long not_taken = solve(i+1, p, people, group, profit)%MOD;
        
        long long taken = solve(i+1, min(thresholdProfit, p+profit[i]), people+group[i], group, profit)%MOD;
        
        return t[i][p][people] = (taken%MOD + not_taken%MOD)%MOD;
        
    }
    
    int profitableSchemes(int n, int minProfit, vector<int>& group, vector<int>& profit) {
        memset(t, -1, sizeof(t));
        N = n;
        thresholdProfit = minProfit;
        return solve(0, 0, 0, group, profit);
        
    }
};
