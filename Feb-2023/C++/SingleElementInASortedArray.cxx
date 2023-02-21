// 540. Single Element in a Sorted Array
class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int left = 0;
        int right = nums.size()-1;
        // we need to compare +1 elements so left<right makes sure there is atleast one element
        while(left<right){
            int mid = left + (right-left) /2;
            if((mid%2==0 && nums[mid]==nums[mid+1]) || (mid%2!=0 && nums[mid]==nums[mid-1])) left=mid+1;
            //as we dont compare mid, we need to add this instead of mid-1, to make sure we dont skip values
            else right=mid;
        }
        return nums[left];
    }
};
