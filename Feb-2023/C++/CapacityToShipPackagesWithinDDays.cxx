// 1011. Capacity To Ship Packages Within D Days

class Solution {

	public:	int shipWithinDays(vector<int> & weights, int days) {

		int low = 0;

		int high = 0;

		int N = weights.size();

		int sum = 0;

		int ans = 0;

		for (int i = 0; i < N; i++) {

			// low will take the lowest capacity without accounting for the days

			if (weights[i] > low) low = weights[i];

			// sum will take the highest capacity which will be for day 1

			sum += weights[i];

		}

		high = sum;

		while (low <= high) {

			int capacity = low + (high - low) / 2;

			if (dayschecker(weights, days, capacity)) {

				ans = capacity;

				high = capacity - 1;

			} else {

				// we didnt find a capacity that could deliver all the products within the given days, so we look for using a higher capacity value to the right of the capacity range (low to high)

				low = capacity + 1;

			}

		}

		return ans;

	}

	int dayschecker(vector<int> & weights, int d, int capacity) {

		int sum = 0;

		//atleast one day to deliver everything

		int days = 1;

		for (int i = 0; i < weights.size(); i++) {

			// if it is less than we can carry, we stop and reset the sum so we can go on the next day, and add one to the day

			if (sum + weights[i] <= capacity) sum += weights[i];

			else {

				sum = weights[i];

				days++;

			}

		}

		// the days required to deliver the product are less than equal to the days we are required to find so we found a new capacity that can deliver everything within the required days, but if we can return a small capacity? so we update the high=mid-1 so look for a smaller capacity

		if (days <= d) return true;

		return false;

	}

};
