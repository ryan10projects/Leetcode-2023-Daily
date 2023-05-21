
// 934. Shortest Bridge
class Solution {
    int m, n;
    int[][] directions = {
            {-1, 0},
            {0, -1}, {0, 1},
            {1, 0}
    };

    boolean isSafe(int i, int j) {
        return (i < m && i >= 0 && j < n && j >= 0);
    }

    void dfs(int[][] grid, int i, int j, Set<Pair<Integer, Integer>> visitedCell) {
        if (!isSafe(i, j) || grid[i][j] == 0 || visitedCell.contains(new Pair<>(i, j))) {
            return;
        }

        visitedCell.add(new Pair<>(i, j));

        for (int[] dir : directions) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];

            dfs(grid, i_, j_, visitedCell);
        }
    }

    int bfs(int[][] grid, Set<Pair<Integer, Integer>> visitedCell) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        for (Pair<Integer, Integer> cell : visitedCell) {
            queue.add(cell);
        }

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                Pair<Integer, Integer> pair = queue.poll();

                for (int[] dir : directions) {
                    int i_ = pair.getKey() + dir[0];
                    int j_ = pair.getValue() + dir[1];

                    if (isSafe(i_, j_) && !visitedCell.contains(new Pair<>(i_, j_))) {
                        if (grid[i_][j_] == 1) { // found another island
                            return level;
                        }

                        visitedCell.add(new Pair<>(i_, j_));
                        queue.add(new Pair<>(i_, j_));
                    }
                }
            }
            level++;
        }

        return level;
    }

    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Set<Pair<Integer, Integer>> visitedCell = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visitedCell); // It will mark one island visited
                    return bfs(grid, visitedCell);
                }
            }
        }

        return -1;
    }
}
