// 879. Profitable Schemes
// algorithm
// Pick current group of people or go to next group and pick them, this will be done using taken and not taken, if I reache the end of group length, this means we saw all the possibilities and will return 1 if true and a group satisfies the minProfit condition 
class Solution {
    int N;
    int mod = 1000000007;
    int[][][] memset;
    public int dfs(int i, int p, int people, int minProfit, int[] group, int[] profit){
       if(memset[i][p][people]!=-1) return memset[i][p][people];
       
        if(people>N) return 0;
        if(i==group.length){
            if(p>=minProfit){
                memset[i][p][people]=1;
                return 1;
            }
                memset[i][p][people]=0;
                return 0;
            
        }
        
       
        int not_taken = dfs(i+1,p,people, minProfit,group,profit)%mod;
        int taken = dfs(i+1,Math.min(minProfit,p+profit[i]),people+group[i], minProfit, group, profit)%mod;        
        return memset[i][p][people]=((taken%mod)+(not_taken)%mod)%mod;       
     }   
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        memset = new int[group.length+1][minProfit+1][n+1];
        for(int[][] j: memset){
            for(int[] i: j){
                Arrays.fill(i,-1);
            }
        }
        N=n;
        return dfs(0,0,0,minProfit,group,profit);
    }
}
