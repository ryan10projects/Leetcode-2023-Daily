// 989. Add to Array-Form of Integer
class Solution {
	public:
	vector<int> addToArrayForm(vector<int> & num, int k) {
		int n = num.size() - 1;
		vector<int> answer;
		int curr = k;
		// as long as either one of them dont satisfy the comdition keep running
		while (n >= 0 || curr > 0) {
			// check if remaining elements exists within the array
			if (n >= 0) {
				curr += num[n];
			}
			answer.push_back(curr % 10);
			curr = curr / 10;
			n--;
		reverse(answer.begin(), answer.end());
		return answer;

	}
};
