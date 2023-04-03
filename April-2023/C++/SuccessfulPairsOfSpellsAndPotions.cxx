// Successful Pairs of Spells and Potions
// Algorithm 
// sort the potion
// spells*potion>success
// sucesss/spells =potion (will give minimum potion)
// then apply binary search

class Solution {
    int res = 0;
public:
    int solve(double minpotion, vector<int>& potion) {
        int low = 0;
        int high = potion.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (potion[mid] >= minpotion) {
                high = mid - 1;
            } else if (potion[mid] <= minpotion) {
                low = mid + 1;
            }
        }
        return low;
    }
    
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        vector<int> ls(spells.size());
        sort(potions.begin(), potions.end());
        double minpotion;
        for (int i = 0; i < spells.size(); i++) {
            minpotion = ceil((1.0 * success) / spells[i]);
            res = solve(minpotion, potions);
            ls[i] = potions.size() - res;
        }
        return ls;
    }
};
