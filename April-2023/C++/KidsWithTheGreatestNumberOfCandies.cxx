// 1431. Kids With the Greatest Number of Candies
class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        vector<bool> l;
        int max = 0;
        for (int n : candies) {
            max = std::max(max, n);
        }
        for (int i = 0; i < candies.size(); i++) {
            if (candies[i] + extraCandies >= max) {
                l.push_back(true);
            }
            else {
                l.push_back(false);
            }
        }
        return l;
    }
};
