// 1802. Maximum Value at a Given Index in a Bounded Array
// Algorithm
// use the formula in getSum, to get the minimum sum of elements in O(1) time
// use binary search to find the biggest value smaller than maxSum
class Solution {
	public long getSum(long count, long x) {
		return count * x - (count * (count + 1) / 2);
	}

	public int maxValue(int n, int index, int maxSum) {
		long left = 1;
		long right = maxSum;
		long result = 0;

		while (left <= right) {

			long mid = left + (right - left) / 2;
			
            // Left sum formula
			long left_count = Math.min((long)index, mid - 1);
			long left_sum = getSum(left_count, mid);

			left_sum += Math.max(0, (long)index - (mid - 1));

            // Right sum formula
			long right_count = Math.min((long)n - index - 1, mid - 1);

			long right_sum = getSum(right_count, mid);

			right_sum += Math.max(0, (long)n - index - 1 - (mid - 1));

			long totalSum = left_sum + mid + right_sum;
           
             // if less than maxSum, loom for more possible values
			if (totalSum <= maxSum) {
				result = Math.max((long)result, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return (int)result;

	}
}
