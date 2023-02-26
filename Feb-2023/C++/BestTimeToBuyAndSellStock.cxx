// 121. Best Time to Buy and Sell Stock

class Solution {

public:

    int maxProfit(vector<int>& prices) {

        if(prices.size()==0 || prices.size()==1) return 0;

        int mini = prices[0];

        int profit = 0;

        for(int i=0; i<prices.size(); i++){
            //buy low
            mini = min(prices[i],mini);
            //sell high (Profit=sp-bp)
            profit = max(profit,prices[i]-mini);

         }

        return profit;

    }

};
