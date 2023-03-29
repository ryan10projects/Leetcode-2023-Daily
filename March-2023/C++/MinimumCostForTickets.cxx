// Minimum Cost For Tickets
/*
3 Steps
Goal
Choice
Constraint
*/
class Solution {
public:
    int t[366];
    int memoized(vector<int>& days, vector<int>& costs, int& n, int idx) {
          // goal
          if(idx == n)
            return 0; //you can't travel, so no cost
                
        if(t[idx] != -1)
            return t[idx];
        
        // Choice and Constraint 1
        int cost_1 = costs[0] + memoized(days, costs, n, idx+1);
            
        int i = idx;

        // Constraint 2
        while(i < n && days[i] < days[idx]+7) {
            i++;
        }
         // Choice 2
        int cost_7 = costs[1] + memoized(days, costs, n, i);
        
        int j = idx;

        // Constraint 3
        while(j < n && days[j] < days[idx]+30) {
            j++;
        }
        // Choice 3
        int cost_30 = costs[2] + memoized(days, costs, n, j);
        
        return t[idx] = min({cost_1, cost_7, cost_30});
    }
    
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        memset(t, -1, sizeof(t));
        int n = days.size();
        return memoized(days, costs, n, 0);
    }
};
