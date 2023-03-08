// 875. Koko Eating Bananas
// Same as minimum time to complete trips
class Solution {
	public boolean minBananaPerHour(int[] piles, int h, int mid) {
		int sum = 0;
		for (int b : piles) {
			sum += b / mid;
			if (b % mid != 0) {
				sum++;
			}
		}
		// all bananas can be eaten under the time limit, so discard right range
		return sum <= h;
	}
	public int minEatingSpeed(int[] piles, int h) {
		int left = 1;
		// maximum banana that can be eaten 
		int right = (int)Arrays.stream(piles).max().getAsInt();
		while (left < right) {
			// mid represents the speed of eating banana
			int mid = left + (right - left) / 2;
			// finding the min banana that can be eaten per hour to complete all the piles under h hours
			if (minBananaPerHour(piles, h, mid)) {
				right = mid - 1;
			} else {
				// we could not finish eating all the piles so we move right
				left = mid + 1;
			}
		}
		return left;
	}
}
