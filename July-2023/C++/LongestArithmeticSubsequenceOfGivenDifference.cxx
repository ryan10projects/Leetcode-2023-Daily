class Solution {
public:
    int longestSubsequence(vector<int>& arr, int difference) {
        unordered_map<int, int> mp;
        int n = arr.size();
        
        int result = 0;
        for(int i = 0; i<n; i++) {
            
            int prev            = arr[i] - difference;
            
            int lengt_till_prev = mp[prev];
            
            mp[arr[i]] = lengt_till_prev + 1;
            
            result = max(result, mp[arr[i]]);
        }
        
        return result;
    }
};
