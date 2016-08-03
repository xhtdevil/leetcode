public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 1)return 0;
        int buyPrice = 0, sellPrice = 0, profit = 0;
        int asc = 0, lastPrice = prices[0];
        // if(prices[0] > prices[1]){
        //     asc = -1;
        // }else if(prices[0] < prices[1]){
        //     buyPrice = prices[0];
        //     asc = 1;
        // }
        
        for(int i = 1; i < n; i++){
            if(prices[i] < lastPrice && asc != -1){
                if(asc != 0){
                    sellPrice = lastPrice;
                    profit += sellPrice - buyPrice;
                }
                asc = -1;
            }
            else if(prices[i] > lastPrice && asc != 1){
                buyPrice = lastPrice;
                asc = 1;
            }
            lastPrice = prices[i];
        }
        if(asc == 1){
            sellPrice = prices[n - 1];
            profit += sellPrice - buyPrice;
        }
        return profit;
    }
}