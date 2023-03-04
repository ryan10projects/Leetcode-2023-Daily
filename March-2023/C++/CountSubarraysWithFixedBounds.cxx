// 2444. Count Subarrays With Fixed Bounds
class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        int minKpos = -1;
    int maxKpos = -1;
    long ans = 0;
    int badnum = -1;
    for(int i = 0; i < nums.size(); i++) {
        if(nums[i] < minK || nums[i] > maxK)
            badnum = i;
        if(nums[i] == minK)
            minKpos = i;
        if(nums[i] == maxK)
            maxKpos = i;
       // Get minimum index from min and Max range
        int num = min(minKpos, maxKpos);
        // If less than 0, no element exists
        long temp = num - badnum;
        ans += temp <= 0 ? 0 : temp;
    }
    return ans;
    }
};
