// 1498. Number of Subsequences That Satisfy the Given Sum Condition
// Algorithmn
// sort
// if nums of right-left<=target
// then all the elements before it can be considered
// 2^(right-left) //where 2 is pick the element or not pick the element and right-left is the number of elements
class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int result = 0;
        int mod = 1000000007;
        int[] power = new int[n];
        power[0]=1;
        for(int i=1; i<n; i++){
            power[i]=(power[i-1]*2)%mod;
        }
        while(left<=right){
            if(nums[right]+nums[left]<=target){
             result = (result%mod+power[right-left]%mod);
             left++;
           }
            else{
             right--;
            }
        }
        return result;
    }
}
