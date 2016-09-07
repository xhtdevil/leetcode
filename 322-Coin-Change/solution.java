public class Solution {
    private int nums = 0;
    // private int min = Integer.MAX_VALUE;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0)return -1;
        Arrays.sort(coins);
        return helper(coins, amount);
    }
    
    private int helper(int[] coins, int amount){
        if(amount == 0)return nums;
        if(map.containsKey(amount))return map.get(amount);
        for(int i = coins.length - 1; i >= 0; i--){
            if(coins[i] > amount)continue;
            int maxNum = amount / coins[i];
            for(int j = maxNum; j > 0; j--){
                nums += j;
                int ans = helper(coins, amount - j * coins[i]);
                if(ans != -1 ){
                    if(!map.containsKey(amount) || map.get(amount) > ans){
                        map.put(amount, ans);
                        
                    }
                }
                nums -= j;
            }
        }
        if(!map.containsKey(amount)){
            map.put(amount, -1);
            return -1;
        }else{
            return map.get(amount);
        }
        
    }
}