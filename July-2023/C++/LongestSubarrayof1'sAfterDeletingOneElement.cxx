// Sliding window O(n)
// 1493. Longest Subarray of 1's After Deleting One Element
class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int i = 0;

        int j = 0;
        
        int last_zero_idx = -1;
        
        int result = 0;
        
        while(j < nums.size()) {
            
            if(nums[j] == 0) {
                i = last_zero_idx+1;
                last_zero_idx = j;
            }
            
            result = max(result, j-i);
            j++;
        }
        
        return result;
    }
};
