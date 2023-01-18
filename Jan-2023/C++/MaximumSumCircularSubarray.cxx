/*
Algorithm
Step 1: Find maximum subarray
Step 2: Find total
Step 3: Find minimum subrray (make all array values negative)
Step 4: Total+Minimum subarray (gives subarray around the borders)
Check for all negatives values if total+minimum subarray=0
*/
// 918. Maximum Sum Circular Subarray
class Solution {
public:
    	int kadane(vector<int> &nums) {
		int sum = 0;
		int maxo = INT_MIN;
		for (int i = 0; i < nums.size(); i++) {
			sum += nums[i];
			maxo = max(sum, maxo);
			if (sum < 0) sum = 0;
		}
		return maxo;
	}

 int maxSubarraySumCircular(vector<int> nums) {
		int maximum_subarray = kadane(nums);
		int total = 0;
		for (int i = 0; i < nums.size(); i++) {
			total += nums[i];
			nums[i] *= -1;
		}
		int minimum_subarray = kadane(nums);
		if (total == minimum_subarray) return maximum_subarray;
		if (total + minimum_subarray == 0) return maximum_subarray;
		return max(maximum_subarray, total + minimum_subarray);
        
 }
