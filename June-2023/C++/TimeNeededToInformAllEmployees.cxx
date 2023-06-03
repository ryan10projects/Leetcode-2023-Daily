// 1376. Time Needed to Inform All Employees
//Algorithm
// To map relationship we add adj matrix with index as the employee (value) and manager as parent (key) 
// starts from time 0
//add the time of current employee with the totaltime every recursion
// get the max time at every recursion (because all messages will already be received with lower time)

class Solution {
public:
    
    int numberOfMinutes = INT_MIN;
    
    void DFS(unordered_map<int, vector<int>> &adj, vector<int>& informTime, int curr_employee, int totalTime) {
        numberOfMinutes = max(numberOfMinutes, totalTime);
        
        for(int &v : adj[curr_employee]) {
            
            DFS(adj, informTime, v, totalTime + informTime[curr_employee]);
            
        }
    }
    
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        unordered_map<int, vector<int>> adj;
        
        for(int i = 0; i < manager.size(); i++) {
            int child     = i;
            int manager_i = manager[i];
            
            if(manager_i != -1)
                adj[manager_i].push_back(child);
        }
        
        DFS(adj, informTime, headID, 0);
        return numberOfMinutes;
    }
};}
