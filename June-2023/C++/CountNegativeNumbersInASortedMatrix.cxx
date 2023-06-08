// 1351. Count Negative Numbers in a Sorted Matrix
// Algorithm
// Use binary search to get negative numbers index
// minus it with the column length to get the number of negative elements
class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int counter = 0;
        for(auto &num: grid){
            int idx = upper_bound(num.begin(), num.end(), 0, greater<>())-num.begin();
            counter+= grid[0].size()-idx;
        }
        return counter;
    }
};
