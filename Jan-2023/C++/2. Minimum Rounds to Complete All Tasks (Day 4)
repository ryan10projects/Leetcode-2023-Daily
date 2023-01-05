//2244. Minimum Rounds to Complete All Tasks

class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        int count = 0;
        map<int,int> mapper;
        for(int t: tasks){
            mapper[t]++;
        }
        
        for(auto &i: mapper){
            if(i.second<2) return -1;
            if(i.second%3!=0){
                //(5/3)
		//5 divides by 3, 1 time and 2 remains so 1 more round
		//(11/3)
		//11/3=9, and 2 remains so one more round left
                count+=(i.second/3)+1;
            }
            else{
                //9 tasks,9/3=3 rounds
                count+=(i.second/3);
                }
        }
        return count;
        
    }
};
