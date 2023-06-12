// 228. Summary Ranges
// 2 pointer approach
class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> result;
        if (nums.empty()) return result;
        if (nums.size() == 1) {
            result.push_back(to_string(nums[0]));
            return result;
        }
        int i = 0, j = 0;
        while (i < nums.size() && j < nums.size()) {
            if (j < nums.size() - 1 && nums[j] + 1 == nums[j + 1]) {
                j++;
            }
            else {
                string s;
                if (i == j) {
                    s = to_string(nums[i]);
                }
                else {
                    s = to_string(nums[i]) + "->" + to_string(nums[j]);
                }
                result.push_back(s);
                i = j + 1;
                j++;
            }
        }
        return result;
    }
};
