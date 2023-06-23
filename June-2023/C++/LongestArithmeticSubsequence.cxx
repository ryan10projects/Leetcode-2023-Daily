// 1027. Longest Arithmetic Subsequence
class Solution {
public:
    int longestArithSeqLength(vector<int>& nums) {
        int n=nums.size();
        
        if(n <= 2)
            return n;
        
        vector<vector<int>> t(n, vector<int>(1001,1));
        

        int result = 0;
        
        for (int i = 1; i<n; i++) {
            
            for (int j=0; j<i; j++) {
                
                int diff    = nums[i] - nums[j] + 500; 
                
                t[i][diff] = t[j][diff] >= 1 ? t[j][diff] + 1 : t[i][diff];
                
                result      = max(result, t[i][diff]);
            }
        }

        return result;
    }
};
