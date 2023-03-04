// 2444. Count Subarrays With Fixed Bounds
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minKpos=-1;
        int maxKpos=-1;
        long ans=0;
        int badnum=-1;
        for(int i=0; i<nums.length;i++){
            if(nums[i]<minK || nums[i]>maxK) badnum=i;
            if(nums[i]==minK) minKpos=i;
            if(nums[i]==maxK) maxKpos=i;
            int num = Math.min(minKpos,maxKpos);
            long temp = num-badnum;
            ans += temp<=0?0:temp;
         }
        return ans;
        
    }
}
