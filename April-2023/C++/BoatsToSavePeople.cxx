// 881. Boats to Save People

class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        sort(people.begin(), people.end());
        int i = 0;
        int j = people.size()-1;
        int boat = 0;
        while(i<=j) {
            if(people[i]+people[j]<=limit) {
                //++,-- move them into boat
                i++;
                j--;
                boat+=1;
            } else {
                j--;
                boat+=1;
            }
        }
        return boat;
    }
};
