
// 131. Palindrome Partitioning

/*Recurison 3 keys
Step 1: Goals
Step 2: Constraints
Step 3: Choice
*/

class Solution {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> ans = new ArrayList<>();
		partition(0, s, res, ans);
		return res;
	}

	void partition(int index, String s, List<List<String>> res, List<String> list) {
		//**Goals**
		//reached end of string
		if (index == s.length()) {
			res.add(new ArrayList<>(list));
			return;
		}
   	//**constraints**
		for (int i = index; i < s.length(); ++i) {
	   //two pointer palindrome checking approach
			if (isPalindrome(s, index, i)) {
				//i-index+1 because we need the length of fhe string
				//i=ending index and index=starting index
				//substracting both will give us the length and +1 for 0 based indexing
				list.add(s.substring(index, i + 1));
	       	//send the next partition
				//choice
				partition(i + 1, s, res, list);
				list.remove(list.size() - 1);

			}
		}

	}

	boolean isPalindrome(String s1, int start, int end) {
		while (start < end) {
			if (s1.charAt(start++) != s1.charAt(end--)) {
				return false;

			}

		}
		return true;

	}
}
