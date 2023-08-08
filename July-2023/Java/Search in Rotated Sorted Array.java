class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[right]){
                left=mid+1;
                }
            else{
                right=mid;
                }
         }
        
        int start=left;
        left=0;
        int end=nums.length-1;
        
        if(target>=nums[start] && target<=nums[end]){
            left=start;
            }
        else {
            end=start;
            }
       
        while(left<=end){
            int mid=left+(end-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<=target){
                left=mid+1;
                }
            else if(nums[mid]>=target){
                end=mid-1;
                }
            
            }
        return -1;
            
    }
}
