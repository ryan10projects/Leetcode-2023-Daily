/*

909. Snakes and Ladders
3 Steps
Goals
Contraints
Choice
*/

class Solution {
	public int snakesAndLadders(int[][] board) {
		int n = board.length;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		boolean[][] visited = new boolean[board.length][board[0].length];
		visited[n - 1][0] = true;
		int steps = 0;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int value = queue.poll();
				// Goal
				if (value == n * n) return steps;
				// Contraints - 1 to 6 steps
				for (int i = 1; i <= 6; i++) {
			        // went beyond board
					if (value + i > n * n) break;
					// find the coordinate so you can use the ladder/snake value
					int[] coordinates = find(value + i, n);
					int r = coordinates[0];
					int c = coordinates[1];
					if (visited[r][c] == true) continue;
					visited[r][c] = true;
					//no snake or ladder
					if (board[r][c] == -1) {
						queue.add(value + i);
					} else {
						//go to snake path or ladder path
						queue.add(board[r][c]);
					}
				}
			}
			steps++;
		}
		return -1;
	}

	public int[] find(int path, int n) {
		int row = (path - 1) / n;
		//game starts from bottom
		int rowBottom = (n - 1) - row;
		int col = (path - 1) % n;
		//numbers go in from zigzag, so if rowbottom and size is same, we can use n-1 minus the column to get the column from right to left
		if ((n % 2 == 0 && rowBottom % 2 == 0) || (n % 2 == 1 && rowBottom % 2 == 1)) {
			col = (n - 1) - col;
		}
		//return grid matrix
		return new int[] {rowBottom, col};

	}
}
