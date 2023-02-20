// 35. Search Insert Position

// O(log n) complexity - Binary Search

// return the index where the target is

// found else return the index+1 where the

// target will be found so we will return left

class Solution {

    public int searchInsert(int[] nums, int target) {

        int left = 0;

        int right = nums.length-1;

        while(left<=right){

            int mid = left + (right-left)/2;            

            if(nums[mid]==target) return mid;

            if(target>=nums[mid]){

                left = mid+1;

             }

            else{

                right=mid-1;

             }

        }

        return left;

    }

}
