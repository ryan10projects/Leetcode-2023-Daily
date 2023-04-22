// 1312. Minimum Insertion Steps to Make a String Palindrome
class Solution {
    int memset[501][501];
public:
    int dfs(string s, int i, int j) {
        // Constraint
        if (i >= j) return 0;
        // Goal
        if (s[i] == s[j]) {
            return dfs(s, i + 1, j - 1);
        }
        if (memset[i][j] != -1) {
            return memset[i][j];
        }
        // Choice
        return memset[i][j] = 1 + min(dfs(s, i + 1, j), dfs(s, i, j - 1));
    }
    int minInsertions(string s) {
        memset(memset, -1, sizeof(memset));
        return dfs(s, 0, s.length() - 1);
    }
};
