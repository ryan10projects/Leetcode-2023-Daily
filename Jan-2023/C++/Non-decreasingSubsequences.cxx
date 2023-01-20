
/* Explanation

In the bck method, check if the index has traversed through the entire nums array,

if it has check if the length is greated than 2 or atleast 2 since we need to return

subsequences and not a single element, if it exist add it into the final res array.

Also use a set for non-repeating charactsrs. In the if statement below, check if the

list is empty or check the previous element in the list with the current element in nums

index. If it is smaller, add it into the list. Ex 3<5. 3 is the last element in the list

and 5 is the element in nums[index], now perform backtracking and keep adding all elements,

after bck is called remove the last element from the list to check all possible combinations,

if it doesn't find any number smaller than current index called the bck method again outside

loop. (If you still didn't understand, try out permutations before doing this problem)

*/
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
