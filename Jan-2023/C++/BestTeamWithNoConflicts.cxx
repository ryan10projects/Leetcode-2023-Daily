// 1626. Best Team With No Conflicts
class Solution {
	public:
	int bestTeamScore(vector<int> & scores, vector<int> & ages) {
		int n = scores.size();
        //making a pair to get all the lowest ages first so we can compare without worrying about the age
		vector<pair<int, int>> player(n);
		for (int i = 0; i < scores.size(); i++) {
			player[i].first = ages[i];
			player[i].second = scores[i];
		}
		//sort by score if age is same or sort by age
		sort(player.begin(), player.end(), [](auto & a, auto & b) {
			return a.first == b.first ? a.second < b.second : a.first < b.first;
		});
       //Classic Longest increasing subsequence approach (learn this first)
		vector<int> dp(n);
		dp[0] = player[0].second;
		int maxsum = dp[0];
		for (int i = 1; i < n; i++) {
			dp[i] = player[i].second;
			for (int j = 0; j < i; j++) {
				if (player[i].second >= player[j].second) {
					dp[i] = max(dp[i], player[i].second + dp[j]);
				}
			}
			maxsum = max(maxsum, dp[i]);

		}
		return maxsum;
	}
};
