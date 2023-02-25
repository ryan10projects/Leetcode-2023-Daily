// 121. Best Time to Buy and Sell Stock

class Solution {

    public int maxProfit(int[] prices) {

        if(prices.length==1 || prices.length==0) return 0;

    

        int max_profit = 0;

        

        int min = prices[0];

        

        for(int i=1; i<prices.length;i++)

        {

            //buy low

            min = Math.min(min,prices[i]);

            //sell high (profit = SP-BP)

            max_profit= Math.max(max_profit, prices[i]-min);

         }

        return max_profit;

    }

}
