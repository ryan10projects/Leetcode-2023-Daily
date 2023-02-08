//The check i==curr is used to determine when a jump is required. The curr variable represents the current jump range, which means that all the positions in the range [0, curr] can be reached in the same number of jumps. When i reaches curr, it means that the current jump range has been fully explored, and a new jump is required to explore further. The new jump range is updated to far, which is the farthest position reachable from the current position, and the number of jumps required is incremented. This process is repeated until the end of the array is reached.

//45. Jump Game II

class Solution {
    public int jump(int[] nums) {
        int curr=0;
        int far=0;
        int jump=0;
        
        for(int i=0;i<nums.length;i++){
            far = Math.max(far,i+nums[i]);
            
            if(i==curr){
                curr=far;
                jump++;
                    
                
                }
            
            }
        return jump;
    }
}
