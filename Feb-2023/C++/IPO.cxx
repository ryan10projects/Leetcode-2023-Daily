// 502. IPO
// Algorithm in short
// we need to make sure whenever we add profits[i], the capital for it should we less than w, and then we can update the w with the profit and start again (Note: we can pick only k items)
class Solution {
	public:
	int findMaximizedCapital(int k, int w, vector<int> & profits, vector<int> & capital) {
		int n = profits.size();
		vector<pair<int, int>> current;
		for (int i = 0; i < n; i++) {
			current.push_back({capital[i], profits[i]});
		}
		sort(current.begin(), current.end());
		// j will act as a pointer to the sliding window
		// priority queue to find the maximum within the sliding window
		// developing a sliding window helps us to know what possible capitals can be added that is less than w
		// to add profits into the current, capital should be less than or equal to current, hence we maintain a vector pair and sort them based on capital
		int j = 0;
		priority_queue<int> pq;
		for (int i = 0; i < k; i++) {
			for (; j < current.size(); j++) {
				if (current[j].first <= w) {
					pq.push(current[j].second);
				} else break;
			}
			if (pq.empty()) break;
			w += pq.top();
			pq.pop();
		}
		return w;
	}
};
