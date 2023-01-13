// 2246. Longest Path With Different Adjacent Characters
class Solution {
	public:
	int res = 0;
	int dfs(unordered_map<int, vector<int>> & map, int curr, int parent, string & s) {
		//two variables declared to pick the longest sub route if two or more valid paths are found, we pick the one with highest length
		int longest = 0;
		int second_longest = 0;

		for (int & child : map[curr]) {
			if (child == parent) continue;

			int current_longest = dfs(map, child, curr, s);
			if (s[child] == s[curr]) continue;

			if (current_longest > second_longest) {
				second_longest = current_longest;
			}
			if (second_longest > longest) {
				swap(longest, second_longest);
			}
		}
		//all adjacent have same values (1)
		int only_root = 1;
				//answer found in sub root /\, cannot add to parent because it wont be a valid path if it has more than two endpoints
		int sub_root = second_longest + longest + 1;
	//answer found in sub but can added be to the parent 
		int sub_and_root = max(longest, second_longest) + 1;
   //get the biggest length
		res = max({res, only_root, sub_root, sub_and_root});
//we wont return only_sub_root because it wont be added to current path
		return max(only_root, sub_and_root);
	}

	int longestPath(vector<int> & parent, string s) {
		unordered_map<int, vector<int>> map;
		for (int i = 1; i < parent.size(); i++) {
			int u = i;
			int v = parent[i];
			map[u].push_back(v);
			map[v].push_back(u);
		}
		dfs(map, 0, -1, s);
		return res;
	}
};
