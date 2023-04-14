// 516. Longest Palindromic Subsequence
//Recursion  
// Choice
// Constraints 
// Goals
class Solution {
    int[][] mem;   // Memoization
    public int solve(String s, int i, int j){
        if(mem[i][j]!=-1) return mem[i][j];
        // constraint
        if(i>j) return 0;
        if(i==j) return 1; //middle element or single element 
        // goal
        if(s.charAt(i)==s.charAt(j)){
            return mem[i][j]=2 + solve(s,i+1,j-1);
        }
        else{
            // choice
            return mem[i][j]=Math.max(solve(s,i+1,j),solve(s,i,j-1));
        }              
   }        
    public int longestPalindromeSubseq(String s) {
        mem = new int[s.length()][s.length()];
        for(int[] i:mem){
            Arrays.fill(i,-1);
        }
       return solve(s,0,s.length()-1);
    }
}
