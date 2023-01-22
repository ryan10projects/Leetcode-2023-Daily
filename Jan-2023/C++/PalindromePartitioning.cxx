
// 131. Palindrome Partitioning

/*Recurison 3 keys
Step 1: Goals
Step 2: Constraints
Step 3: Choice
*/

class Solution {
	public:
	vector<vector<string>> partition(string s) {
		vector<vector<string>> result;
		vector<string> list;
		backtrack(s, result, list, 0);
		return result;
	}

	void backtrack(string s, vector<vector<string>> & result, vector<string> & list, int index) {
		//**Goals**
		//reached end of string
		if (index == s.length()) {
			result.push_back(list);
			return;
		}
		//**constraints**
		for (int i = index; i < s.length(); i++) {
			//two pointer palindrome checking approach
			if (palindrome(s, index, i)) {
				//i-index+1 because we need the length of fhe string
				//i=ending index and index=starting index
				//substracting both will give us the length and +1 for 0 based indexing
				list.push_back(s.substr(index, i - index + 1))
				//send the next partition
				//choice
				backtrack(s, result, list, i + 1);
				list.pop_back();
			}
		}
	}

	bool palindrome(string s, int start, int end) {
		while (start <= end) {
			if (s[start] != s[end]) return false;
			start++;
			end--;
		}
		return true;


	}
};
