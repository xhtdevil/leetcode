public class Solution {
    private int nums = 0;
    private int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0)return -1;
        Arrays.sort(coins);
        
        // if(min == Integer.MAX_VALUE){
        //     return -1;
        // }
        // else return min;
        return helper(coins, amount);
    }
    
    private int helper(int[] coins, int amount){
        // if(amount == 0 && nums < min){
        //     min = nums;
        //     return;
        // }
        if(amount == 0)return nums;
        if(amount < 0)return -1;
        for(int i = coins.length - 1; i >= 0; i--){
            int maxNum = amount / coins[i];
            for(int j = maxNum; j > 0; j--){
                nums += j;
                int ans = helper(coins, amount - j * coins[i]);
                if(ans != -1)return ans;
                nums -= j;
            }
        }
        return -1;
    }
}