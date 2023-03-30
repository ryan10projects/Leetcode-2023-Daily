// Number of Zero-Filled Subarrays
// Algorithm
// Get the count of continuous zero then add it in resulta
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result=0;
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                count++;
            }
            else{
                count=0;
            }
            result+=count;
        }
        return result;
    }
}
