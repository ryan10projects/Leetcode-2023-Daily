// Sliding Window o(n)
//1493. Longest Subarray of 1's After Deleting One Element
class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0, j = 0, lastIndex = -1, result=0;
        
        while(j < nums.length){
            
             if(nums[j]==0){
                 i = lastIndex+1;
                 lastIndex = j;
              }   
             
            result = Math.max(result,j-i);
            j++;
            
        }
        return result;
    }
}
