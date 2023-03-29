// Reducing Dishes
/* 3 Steps
Goal
Constraints
Choice
*/
class Solution {
    int[][] arr = new int[501][501];
    public int solve(int[] satisfaction, int time, int index, int n){
        // Goal
        if(index==n) return 0;
        
        // Memoization
        if(arr[index][time]!=-1){
            return arr[index][time];
        }
        // Choice  & constraint
        int include =satisfaction[index]*time + solve(satisfaction,time+1,index+1,n);       
        int exclude = solve(satisfaction,time,index+1,n);
        return arr[index][time]=Math.max(include,exclude);        
    }
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        for(int[] a: arr){
        Arrays.fill(a,-1);
        }
        int n = satisfaction.length;
        return solve(satisfaction,1,0,n);
    }
}
