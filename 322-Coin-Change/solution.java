public class Solution {
    private int nums = 0;
    // private int min = Integer.MAX_VALUE;
    //Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0)return -1;
        //Arrays.sort(coins);
        int[] map = new int[amount + 1];
        for(int i = 0; i < amount + 1; i++){
            map[i] = 0;
        }
        helper(coins, amount, map);
        return map[amount];
    }
    
   
    
    private void helper(int[] coins, int amount, int[] map){
        if(amount == 0 || map[amount] != 0)return;
       // if(map[amount] != 0)return map[amount];
        for(int i = coins.length - 1; i >= 0; i--){
            if(coins[i] > amount)continue;
            int maxNum = amount / coins[i];
            for(int j = maxNum; j > 0; j--){
                helper(coins, amount - j * coins[i], map);
                if(map[amount - j * coins[i]] == -1)continue;
                if(map[amount] == 0 || (j + map[amount - j * coins[i]]) < map[amount]){
                    map[amount] = j + map[amount - j * coins[i]];    
                }
                // nums += j;
                // int ans = helper(coins, amount - j * coins[i], map);
                // if(ans != -1 ){
                //     if(map[amount] == 0 || map[amount] > ans){
                //         map[amount] = ans;
                        
                //     }
                // }
                // nums -= j;
            }
        }
        
        if(map[amount] == 0){
            map[amount] = -1;
        }

        //    return map[amount];
        
    }
}