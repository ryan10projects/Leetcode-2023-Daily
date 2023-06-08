// 1351. Count Negative Numbers in a Sorted Matrix
// Algorithm
// Use binary search to get negative numbers index
// minus it with the column length to get the number of negative elements

class Solution {
	public int binarysearch(int[] row, int left, int right) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (row[mid] >= 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}
	public int countNegatives(int[][] grid) {
		int count = 0;
		for (int[] row : grid) {
			int idx = binarysearch(row, 0, row.length - 1);
			count += grid[0].length - idx;
		}
		return count;
	}
}
