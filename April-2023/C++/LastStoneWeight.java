// 1046. Last Stone Weight
// Algorithm
// keep removing last two biggest elements and add them after finding the difference
class Solution {
	public:
	int lastStoneWeight(vector<int> & stones) {
		while (stones.size() > 1) {
			sort(stones.begin(), stones.end());
			int a = stones.back();
			stones.pop_back();
			int b = stones.back();
			stones.pop_back();
			stones.push_back(a - b);
		}
		return stones[0];
	}
};
