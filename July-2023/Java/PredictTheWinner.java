class Solution {
    int[][] dp;
    public int solve(int[] nums, int left, int right){
        if(left>right) return 0;
        if(left==right) return nums[left];
        if(dp[left][right]!=-1) return dp[left][right];
        //player 1 best + solve(Player 2 worse)
        // inside Math.min, if player 2 picks left then player 1 can pick left+2 next turn, else if player 2 picks right, we reduce right ONLY (left+1 because player 1 picked left, so to avoid picking it again we do left+1) 
        // this leaves player 1 of range left+1 to right
        int left_sum = nums[left] + Math.min(solve(nums,left+2,right),solve(nums,left+1,right-1));
        // this leaves player 1 of range left to right-1
        int right_sum = nums[right] + Math.min(solve(nums,left,right-2),solve(nums,left+1,right-1));
        
        return dp[left][right]=Math.max(left_sum,right_sum);
    }
    public boolean PredictTheWinner(int[] nums) {
        dp = new int[21][21];
        for(int[] arr: dp) Arrays.fill(arr,-1);
        int sum = 0;
        for(int i: nums) sum+=i;
        int player_1 = solve(nums, 0, nums.length-1);
        int player_2 = sum-player_1;
        return player_1>=player_2;
    }
}
