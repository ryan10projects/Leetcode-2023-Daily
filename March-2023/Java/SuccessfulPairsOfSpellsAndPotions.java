// Successful Pairs of Spells and Potions
// Algorithm 
// sort the potion
// spells*potion>success
// sucesss/spells =potion (will give minimum potion)
// then apply binary search

class Solution {
	int res = 0;
	public int solve(double minpotion, int[] potion) {
		int low = 0;
		int high = potion.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (potion[mid] >= minpotion) {
				high = mid - 1;
			} else if (potion[mid] <= minpotion) {
				low = mid + 1;
			}
		}
		return low;
	}
	public int[] successfulPairs(int[] spells, int[] potions, long success) {

		int[] ls = new int[spells.length];
		Arrays.sort(potions);
		double minpotion;
		int count = 0;
		for (int i = 0; i < spells.length; i++) {
			minpotion = Math.ceil((1.0) * success / spells[i]);
			res = solve(minpotion, potions);
			ls[i] = potions.length - res;
		}
		return ls;
	}
}
