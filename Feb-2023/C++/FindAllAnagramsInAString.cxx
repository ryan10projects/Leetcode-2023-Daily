// Find All Anagrams in a String
// Maintain a sliding window, Add elements from fhe front and delete elements from the behind to maintain the same length as p String. Then compare fhem
//Same as permutation in a string just add the start index
class Solution {
	public:
	vector<int> findAnagrams(string s, string p) {
		vector<int> res;
		if (p.length() > s.length()) return res;
		if (p == s) {
			res.push_back(0);
			return res;
		}
		int freq1[26];
		int freq2[26];
		int start = 0;
		memset(freq1, 0, sizeof freq1);
		memset(freq2, 0, sizeof freq2);
		for (int i = 0; i < p.length(); i++) {
			freq1[p[i] - 'a']++;
			freq2[s[i] - 'a']++;
		}
		if (memcmp(freq1, freq2, sizeof(freq1)) == 0) {
			res.push_back(start);
		}
		for (int i = p.length(); i < s.length(); i++) {
			start++;
			freq2[s[i] - 'a']++;
			freq2[s[i - p.length()] - 'a']--;
			if (memcmp(freq1, freq2, sizeof(freq1)) == 0) {
				res.push_back(start);
			}
		}
		return res;
	}
};
