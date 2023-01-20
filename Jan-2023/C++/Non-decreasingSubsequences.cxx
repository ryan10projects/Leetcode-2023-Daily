
class Solution {
	public:
	vector<vector<int>> findSubsequences(vector<int> & nums) {
		set<vector<int>> res;
		vector<int> list;
		bck(res, list, nums, 0);
		vector<vector<int>> result(res.begin(), res.end());
		return result;
	}
	void bck(set<vector<int>> & res, vector<int> & list, vector<int> & nums, int size) {
		if (nums.size() == size) {
			if (list.size() >= 2) {
				res.insert(list);
			}
			return;
		}

		if (list.empty() || list.back() <= nums[size]) {
			list.push_back(nums[size]);
			bck(res, list, nums, size + 1);
			list.pop_back();

		}
		bck(res, list, nums, size + 1);
	}
};
