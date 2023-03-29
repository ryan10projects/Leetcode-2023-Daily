// Reducing Dishes
/* 3 Steps
Goal
Constraints
Choice
*/
class Solution {
public:
   
    int arr[501][501];
    int n;
    int solve(vector<int>& satisfaction, int time, int index){
        // Goal
        if(index>=n) return 0;
        // Memoization to prevent Timeout 
        if(arr[index][time]!=-1){
            return arr[index][time];
        }
        // Constraints and Choice
        int include = satisfaction[index]*time+solve(satisfaction,time+1,index+1);
        int exclude = solve(satisfaction,time,index+1);
        return arr[index][time]= max(include,exclude);
    }
    
    int maxSatisfaction(vector<int>& satisfaction) {
        memset(arr,-1,sizeof(arr));
        // sort to make sure the element at the end is multiplied with highest time for biggest value
        sort(satisfaction.begin(), satisfaction.end());
        n = satisfaction.size();
        return solve(satisfaction,1,0);
    }
};
