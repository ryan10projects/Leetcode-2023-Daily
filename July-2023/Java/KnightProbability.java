

class Solution {
    Map<String, Double> mp = new HashMap<>();
    int[][] directions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

    double helper(int N, int K, int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N)
            return 0;

        if (K == 0)
            return 1; // One possibility over, return now

        String key = K + "_" + row + "_" + col;

        if (mp.containsKey(key))
            return mp.get(key);

        double ans = 0;
        for (int[] dir : directions) {
            int new_row = row + dir[0];
            int new_col = col + dir[1];
            ans += helper(N, K - 1, new_row, new_col);
        }

        double probability = ans / 8.0;
        mp.put(key, probability);
        return probability;
    }

    public double knightProbability(int n, int k, int row, int column) {
        return helper(n, k, row, column);
    }
}
