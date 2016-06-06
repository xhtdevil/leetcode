public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){return 0;}
        int[] profit = profitArray(prices);
        int i = 0;
        int j = i;
        int max = 0, sum = 0;
        while(j < profit.length){
            sum += profit[j];
            if(sum > max){
                max = sum;
                j++;
            }
            else if(sum < 0){
                sum = 0;
                i = j + 1;
                j = i;
            }
            else{j++;}
        }
        return max;
    }
    
    private int[] profitArray(int[] prices){
        int[] profit = new int[prices.length - 1];
        for(int i = 0; i < profit.length; i++){
            profit[i] = prices[i + 1] - prices[i];
        }
        return profit;
    }
}