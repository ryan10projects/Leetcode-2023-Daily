// 1822. Sign of the Product of an Array
class Solution {
    public int signFunc(int num){
        if(num>0) return 1;
        if(num<0) return -1;
        return 0;
        
    }
    public int arraySign(int[] nums) {
        int num=nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]>0){
                num*=1;
            }
            else if(nums[i]<0){
                num*=-1;
            }
            else{
                num*=0;
            }
        }
        return signFunc(num);
    }
}
