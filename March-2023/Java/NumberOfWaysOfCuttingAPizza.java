// Number of Ways of Cutting a Pizza
class Solution {
    
    int[][] apples = new int[51][51];    
    // refer to question, we need to mod the answer
    int mod = 1000000007;
    // store the 3 states, current row, column, users
    int[][][] dp = new int[51][51][51];
    public int solve(int m, int n, int i, int j, int k)
    {
        // if count is less than total members, descard 
        if(apples[i][j]<k){
            return 0;
        }
        if(dp[i][j][k]!=-1) return dp[i][j][k];
        // if there is only one apple, the pizza should contain one apple atleast
        if(k==1){
            if(apples[i][j]>=1){
                return 1;
            }
            return 0;
        }
        int ans=0;       
        // horizontal slice
        for(int h=i+1;h<m; h++){
            // get count of all apples in lower
            int lower = apples[h][j];
            // total - lower of current sub matrix will get the count of the current piece
            int upper = apples[i][j]-lower;
            if(upper>=1 && lower>=k-1){
                ans=(ans%mod + solve(m,n,h,j,k-1)%mod)%mod;
            }
        }       
        // vertical slice
        for(int v=j+1; v<n; v++){
            int right = apples[i][v];
            int left = apples[i][j]-right;
            if(left>=1 && right>=k-1){
                // mod the ans according to question
                ans=(ans%mod+solve(m,n,i,v,k-1)%mod)%mod;
            }
            
        }
        return dp[i][j][k]=ans;        
    }
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        for(int[][] arr: dp){
            for(int[] a: arr){
                Arrays.fill(a,-1);
            }          
        }
        // doing this we can get the count of apples of any submatrix we partition it from 
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                apples[i][j]=apples[i][j+1];
                for(int l=i; l<m; l++){
                    if(pizza[l].charAt(j)=='A'){
                        apples[i][j]+=1;
                    }
                }
               
            }           
        }        
        return solve(m,n,0,0,k);
    }
}
