/*Maintain two pointers so you can update the entire array in a single iteration
*/
// 1470. Shuffle the Array
class Solution {
	public int[] shuffle(int[] nums, int n) {
		int[] arr = new int[n * 2];
		int j = 0;
		for (int i = 0; i < n; i++) {
			arr[j] = nums[i];
			j++;
			arr[j] = nums[i + n];
			j++;
		}
		return arr;
	}
}
