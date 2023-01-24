/*

909. Snakes and Ladders

3 Steps

Goals

Contraints

Choice

*/

class Solution {

	public:	int snakesAndLadders(vector<vector<int>> & board) {

		int n = board.size();

		queue<int> q; 

		q.push(1);

		vector<vector<bool>> visited;

		visited.resize(n, vector<bool>(n,false));

		

		visited[n - 1][0] = true;

		int steps = 0;

		while (!q.empty()) {

			int size = q.size();

			while (size-- > 0) {

				int value = q.front();

				q.pop();

				// "***Goal****

				if (value == n * n) return steps;

				// ***Contraints***

				//  1 to 6 steps

				for (int i = 1; i <= 6; i++) {

					 // went beyond board

					if (value + i > n * n) break;

					// find the coordinate so you can use the ladder/snake value

					int r, c;

					find(value + i, n, r, c);

					if (visited[r][c]) continue;

					visited[r][c] = true;

					//Choice

					//no snake or ladder

					if (board[r][c] == -1) {

						q.push(value + i);

					} else {

						//go to snake path or ladder path

						q.push(board[r][c]);

					}

				}

			}

			steps++;

		}

		return -1;

	}

	void find(int path, int n, int & r, int & c) {

		r = (path - 1) / n;

		r = (n - 1) - r;

		c = (path - 1) % n;

		if ((n % 2 == 0 && r % 2 == 0) || (n % 2 == 1 && r % 2 == 1)) {

			c = (n - 1) - c;

		}

	}

};
