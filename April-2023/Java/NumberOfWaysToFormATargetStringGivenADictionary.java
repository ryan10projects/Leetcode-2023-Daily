// 1639. Number of Ways to Form a Target String Given a Dictionary
class Solution {
    int[][] mem;
    long[][] freq;
    int n;
    int m;
    // Return answer with mod 10^9+7 (as per question)
    final int mod = 1000000007;
    
    public int solve(int i, int j, String target) {
        if(mem[i][j] != -1) return mem[i][j];
        // Constraints
        if(i >= m) return 1;
        if(j >= n) return 0;
        // Choice 1
        int not_taken = solve(i, j+1, target) % mod;
        // Choice 2
        // Cause frequency is long
        // Get all the frequency eg A. That will be the number of ways we can choose the same alphabet when looping
        int taken = (int) ((freq[target.charAt(i) - 'a'][j] * solve(i+1, j+1, target)) % mod);
        // Goal
        return mem[i][j] = (not_taken + taken) % mod;
    }
    
    public int numWays(String[] words, String target) {
        n = words[0].length();
        m = target.length();
        freq = new long[26][1001];
        mem = new int[1001][1001];
        
        for(int i = 0; i < 1001; i++) {
            Arrays.fill(mem[i], -1);
        }
        
        for (String word : words) {
    for (int j = 0; j < n; j++) {
        char c = word.charAt(j);
        int index = c - 'a';
        freq[index][j]++;
    }
}

        
        
        return solve(0, 0, target);
    }
}
