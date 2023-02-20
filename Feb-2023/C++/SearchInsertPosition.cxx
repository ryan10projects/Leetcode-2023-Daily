// 35. Search Insert Position

// O(log n) complexity - Binary Search

// return the index where the target is

// found else return the index+1 where the

// target will be found so we will return left

class Solution {

public:

    int searchInsert(vector<int>& nums, int target) {

        int left=0;

        int right=nums.size()-1;

        

        while(left<=right){

            int mid = left+(right-left)/2;

            if(nums[mid]==target){

                return mid;

            }

            else if(nums[mid]>=target){              

                right=mid-1;

             }

            else {

                left=mid+1;

             }

        }

        return left;

    }

};
