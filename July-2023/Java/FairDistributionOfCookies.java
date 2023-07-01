// 2305. Fair Distribution of Cookies
// Algorithm
// Multiple choices to consider so go with for loop to accommodate it
// Constraint
// Goal
// Choice
class Solution {
    int result = Integer.MAX_VALUE;
    int K;
    
    public void dfs(int[] children, int[] cookies, int idx) {
        // Constraint
        if (idx >= cookies.length) {
            int maxi = Integer.MIN_VALUE;
            // Goal
            for (int i : children) {
                maxi = Math.max(maxi, i);
            }
           //
            result = Math.min(result, maxi);
            return;
        }
        
        int candies = cookies[idx];
       // Choices
       // add explore remove
        for (int i = 0; i < K; i++) {
            children[i] += candies;
            dfs(children, cookies, idx + 1);
            children[i] -= candies;
        }
    }
    
    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k];
        Arrays.fill(children, 0);
        this.K = k;
        dfs(children, cookies, 0);
        return result;
    }
}
