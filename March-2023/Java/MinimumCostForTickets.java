// Minimum Cost For Tickets
/*
3 Steps
Goal
Choice
Constraint
*/

class Solution {
    int[] arr = new int[365];
    public int solve(int[] days, int[] cost, int n, int index){
        
        //goal
        if(index>=n){
            return 0;
        }
        
        // memoization
        if(arr[index]!=-1){
            return arr[index];
        }
        
        // choice  and constraint 1
        int cost_1 = cost[0]+solve(days,cost,n,index+1);
        
        int i = index;
        
        // contraint 2 
        while(i<n && days[i]<days[index]+7){
            i++;
        }
        // choice 2
        int cost_2 = cost[1]+solve(days,cost,n,i);
        
        int j = index;
        
        // constraint 3
        while(j<n && days[j]<days[index]+30){
            j++;
        }
        
        // choice 3
        int cost_3 = cost[2]+solve(days,cost,n,j);        
        return arr[index]=Math.min(cost_1,Math.min(cost_2,cost_3));
               
    }
    public int mincostTickets(int[] days, int[] costs) {        
        int index = 0;       
         Arrays.fill(arr,-1);
        int n = days.length;
        return solve(days,costs,n,index);
       
    }
}
