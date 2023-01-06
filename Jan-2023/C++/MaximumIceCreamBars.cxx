// 1833. Maximum Ice Cream Bars
class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        //buy the cheapest icecreams first using sort
        sort(costs.begin(),costs.end());
        int amount=0;
        for(int i=0;i<costs.size();i++){
            if(coins-costs[i]>=0){
                coins-=costs[i];
                //amount of icecreams brought
                amount++;
            }
            if(coins==0) break;
        }
        return amount;
    }
};
