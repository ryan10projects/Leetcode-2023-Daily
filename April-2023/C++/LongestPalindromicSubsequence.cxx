// 516. Longest Palindromic Subsequence
// Recursion  
// Choice
// Constraints 
// Goals

class Solution {
public:
    int mem[1001][1001]; // Memoization

    int solve(string s, int i, int j) {
        if (mem[i][j] != -1) return mem[i][j];
        // constraint
        if (i > j) return 0;
        if (i == j) return 1; //middle element or single element 
        // goal
        if (s[i] == s[j]) {
            return mem[i][j] = 2 + solve(s, i+1, j-1);
        }
        else {
            // choice
            return mem[i][j] = max(solve(s, i+1, j), solve(s, i, j-1));
        }
    }

    int longestPalindromeSubseq(string s) {
        memset(mem, -1, sizeof(mem)); // Initialize memoization array with -1
        return solve(s, 0, s.length()-1);
    }
};
