public class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = 0, sellPrice = 0, profit = 0;
        int n = prices.length;
        if(n <= 1)return 0;
        for(int i = 0; i < n; i++){
            if(i == 0 && prices[i + 1] > prices[i]){
                buyPrice = prices[i];
            }
            else if(i == n - 1 && prices[i - 1] < prices[i]){
                sellPrice = prices[i];
                profit += sellPrice - buyPrice;
            }
            else if(prices[i] < prices[i - 1] && prices[i] < prices[i + 1]){
                buyPrice = prices[i];
            }
            else if(prices[i] > prices[i + 1] && prices[i] > prices[i - 1]){
                sellPrice = prices[i];
                profit += sellPrice - buyPrice;
            }
        }
        return profit;
    }
}