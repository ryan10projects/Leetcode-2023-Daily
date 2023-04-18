// 1768. Merge Strings Alternately
class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        string res = "";
        int i = 0;
        int min_len = min(word1.length(), word2.length());
        while (i < min_len) {
            res += word1[i];
            res += word2[i];
            i++;
        }
        while (i < word1.length()) {
            res += word1[i];
            i++;
        }
        while (i < word2.length()) {
            res += word2[i];
            i++;
        }
        return res;
    }
};
