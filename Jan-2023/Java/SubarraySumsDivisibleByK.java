/* Subarray Sums Divisible by K
Algorithm
Step 1: Get cumulative sum
Step 2: fetch remainder
Step 3: Check if remainder is in HashMap
Step 4: Add the count of remainder in HashMap
Step 5: Return Count
If remainder less than 0, add the divisor
*/ 



class Solution {
	public int subarraysDivByK(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int count = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int remainder = sum % k;
			if (remainder < 0) remainder += k;
			if (map.containsKey(remainder)) {
				count += map.get(remainder);
			}
			map.put(remainder, map.getOrDefault(remainder, 0) + 1);

		}
		return count;
	}
}
