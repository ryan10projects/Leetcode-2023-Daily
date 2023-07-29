class Solution {
public:
    
    int m;
    
    int n:
    
    int target_mask;
    
    vector<int> result;
    
    unordered_map<string , int > dp;
    
    void solve(vector<int> &people_skill , int idx , vector<int> &temp, int mask ) {
        
       if(idx == people_skill.size()) {
           
           if(mask == target_mask) {
               
               if(result.size() == 0 || result.size() >= temp.size()) {
                   result = temp;
               }
           }
           return;
       }
        
        string s = to_string(idx) + to_string(mask);
        
         if(dp.find(s) != dp.end()) {
           
           if(dp[s] <= temp.size())
               return ; 
        }
        
        if(result.size() != 0 && temp.size() >= result.size()) 
            return; 
        
        solve(people_skill , idx + 1 , temp , mask ); 
        
         if( (mask | people_skill[idx]) != mask) { 
            temp.push_back(idx);
            solve(people_skill, idx + 1, temp , mask | people_skill[idx]);

            temp.pop_back();
            dp[s] = (temp.size() != 0 ) ? temp.size() : -1;
        }
    }
    
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        n = req_skills.size();                                                                                          
        m = people.size();
        
        unordered_map<string, int> skills; 
        for (int i = 0; i < n; ++i)
            skills[req_skills[i]] = i;
        
        
        vector<int> people_skill;
        for (auto &v: people) {
            int skill_bit = 0;
            for (string &skill: v)
                skill_bit |= 1 << skills[skill];
            
            people_skill.push_back(skill_bit);
        }
        
      
        target_mask = pow(2, n) - 1;
        vector<int> temp;
        solve(people_skill, 0, temp, 0);
        return result;
    }
};