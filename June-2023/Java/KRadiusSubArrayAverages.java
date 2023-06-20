// 2090. K Radius Subarray Averages
// Algorithm
// find cumulative sum
// add the cumulative sum of index+k, to get the sum up to those elements, that is the answer
// if it is greater than 0, remove all the sum in one operation before i-k-1 index to not consider them
class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0) return nums;
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        if(nums.length<2*k+1) return result;
       long[] cs = new long[nums.length];
        cs[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            cs[i]=(long)(cs[i-1]+nums[i]);
        }
        for(int i=k; i<=nums.length-k-1; i++){
           
            long sum=cs[i+k];
            if(i-k>0){
                sum-=cs[i-k-1];
            }
            // For example, let's say the sum is 7 and the divisor is 3. If you perform integer division (7 / 3), the result will be 2. However, if you perform floating-point division (7 / 3.0), the result will be 2.3333333333333335, which better represents the true average.
            int total = (int) (sum / (double) (2 * k + 1));
            
            result[i]=total;
       }
        return result;
    }
}
