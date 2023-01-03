//944. Delete Columns to Make Sorted
class Solution {
	public int minDeletionSize(String[] strs) {
		int count = 0;
		//[a, l, p],
		//[b, m, q]
		//in the above example compare if a>b, if it is greater then increment count
		for (int i = 0; i < strs[0].length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
					count++;
					break;
				}
			}

		}
		return count;
	}
}
