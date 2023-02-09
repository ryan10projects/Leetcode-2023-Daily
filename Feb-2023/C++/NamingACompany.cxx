// 2306. Naming a Company
/*Algorithm
We will compare the suffix only and use the first letter as key.
If the suffix is not same in both the group, we have found a unique element
HashSet for better memory searching.
26 times to not look for the same character twice in case of duplicates.
multiplying both unique group of elements at the end for unique pairs for each character, we will not add here.
*/
class Solution {
	public:
	long long distinctNames(vector<string> & ideas) {
		unordered_map<char, unordered_set<string>> map;
		long res = 0;
		for (int i = 0; i < 26; i++) {
			map['a' + i] = unordered_set<string>();
		}
		for (string s : ideas) {
			map[s[0]].insert(s.substr(1));
		}
		for (int i = 0; i < 25; i++) {
			for (int j = i + 1; j < 26; j++) {
				long group_1_common = 0;
				long group_2_common = 0;
				unordered_set<string> s1 = map['a' + i];
				unordered_set<string> s2 = map['a' + j];
				for (string c : s2) {
					if (s1.find(c) == s1.end()) {
						group_1_common++;
					}
				}
				for (string c : s1) {
					if (s2.find(c) == s2.end()) {
						group_2_common++;
					}
				}
				res += group_1_common * group_2_common;
			}
		}
		return 2 * res;
	}
};
