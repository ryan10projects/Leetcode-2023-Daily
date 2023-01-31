// 1626. Best Team With No Conflicts
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] player = new int[n][2];
        //making a pair to get all the lowest ages first so we can compare without worrying about the age
        for(int i=0; i<scores.length;i++)
        {
            player[i][0]=ages[i];
            player[i][1]=scores[i];
        }
        //sort by score if age is same or sort by age
        Arrays.sort(player, (a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
           //Classic Longest increasing subsequence approach (learn this first)
        int[] dp = new int[n];
        dp[0]=player[0][1];
        int maxsum=dp[0];
        for(int i=0; i<scores.length; i++){
            dp[i]=player[i][1];
            for(int j=0; j<i; j++){
                if(player[i][1]>=player[j][1]){
                    dp[i]=Math.max(dp[i],player[i][1]+dp[j]);
                    }
                
             }
            maxsum=Math.max(dp[i],maxsum);
      }
        return maxsum;
    }
}
