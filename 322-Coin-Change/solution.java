public class Solution {
    //time exceed, recursion using array to record
    // public int coinChange(int[] coins, int amount) {
    //     if(coins.length == 0)return -1;
    //     int[] map = new int[amount + 1];
    //     for(int i = 0; i < amount + 1; i++){
    //         map[i] = 0;
    //     }
    //     helper(coins, amount, map);
    //     return map[amount];
    // }
    
    // private void helper(int[] coins, int amount, int[] map){
    //     if(amount == 0 || map[amount] != 0)return;
    //     for(int i = coins.length - 1; i >= 0; i--){
    //         if(coins[i] > amount)continue;
    //         int maxNum = amount / coins[i];
    //         for(int j = maxNum; j > 0; j--){
    //             helper(coins, amount - j * coins[i], map);
    //             if(map[amount - j * coins[i]] == -1)continue;
    //             if(map[amount] == 0 || (j + map[amount - j * coins[i]]) < map[amount]){
    //                 map[amount] = j + map[amount - j * coins[i]];    
    //             }
    //         }
    //     }
        
    //     if(map[amount] == 0){
    //         map[amount] = -1;
    //     }
    // }
    
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int rem, int[] count) { 
        // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
        if(rem<0) return -1; // not valid
        if(rem==0) return 0; // completed
        if(count[rem-1] != 0) return count[rem-1]; // already computed, so reuse
        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            int res = helper(coins, rem-coin, count);
            if(res>=0 && res < min)
                min = 1+res;
        }
        count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
        return count[rem-1];
    }
}