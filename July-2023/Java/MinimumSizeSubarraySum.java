class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int maxi = Integer.MAX_VALUE;
        int sum = 0;
        while(right<nums.length){
            sum+=nums[right];
          // goal reach
          // use a while loop to end goal and check for next goal
            while(sum>=target){
                maxi = Math.min(right-left+1,maxi);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return maxi==Integer.MAX_VALUE?0:maxi;
    }
}
