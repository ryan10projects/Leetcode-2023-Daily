// Minimize Maximum of Array
// Equally distribute all values
// +1 to not divide by 0
// Fetch average of every running sum and return the maximum
class Solution {
    public int minimizeArrayValue(int[] nums) {
        long res=0, sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            res = Math.max(res, (long)(sum+i)/(i+1));
            
        }
        return (int)res;
    }
}
