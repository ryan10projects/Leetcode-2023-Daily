// 2448. Minimum Cost to Make Array Equal
// Algorithm
// we will start from middle and calculate mid cost and midplus one cost
// if midplus is greater, we look to the left
// left and right gives us the boundary, which makes yhe operation possible

class Solution {
	public long costprediction(long mid, int[] nums, int[] cost) {
		long totalcost = 0;
		for (int i = 0; i < cost.length; i++) {
			long diff = Math.abs(mid - nums[i]);
			totalcost += diff * cost[i];

		}
		return totalcost;

	}

	public long minCost(int[] nums, int[] cost) {
		long result = Integer.MAX_VALUE;
		long left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;

		for (long i : nums) {
			left = Math.min(left, i);
			right = Math.max(right, i);
		}

		while (left <= right) {
			long mid = left + (right - left) / 2;
			long midcost = costprediction(mid, nums, cost);
			long midplusone = costprediction(mid + 1, nums, cost);
	
			if (midplusone > midcost) {
				result = Math.min(midplusone, midcost);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}4
		return result;
	}
}
