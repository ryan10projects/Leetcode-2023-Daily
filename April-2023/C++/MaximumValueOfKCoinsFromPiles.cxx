class Solution {
public:
    vector<vector<int>> mem;
    int solve(vector<vector<int>>& piles, int i, int k) {
        // constraint
        if (i >= piles.size()) return 0;
        if (mem[i][k] != -1) {
            return mem[i][k];
        }
        // choice
        // skip the pile
        int not_taken = solve(piles, i + 1, k);
        int sum = 0;
        int taken = 0;
        // For example, if k is 5 and the size of the current pile is 3, then we can only take up to 3 items from the pile. In this case, Math.min(list.size(), k) will return 3, so the for loop will iterate over the first 3 elements of the pile.

        // If k is 2 and the size of the current pile is 5, then we can take up to 2 items from the pile. In this case, Math.min(list.size(), k) will return 2, so the for loop will only iterate over the first 2 elements of the pile.
        for (int j = 0; j < min(k, (int)piles[i].size()); j++) {
            sum += piles[i][j];
            // take the pile
            taken = max(taken, sum + solve(piles, i + 1, k - (j + 1)));

        }
        // Goal
        return mem[i][k] = max(taken, not_taken);
    }

    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        mem.resize(1001, vector<int>(2001, -1));
        return solve(piles, 0, k);
    }
};
