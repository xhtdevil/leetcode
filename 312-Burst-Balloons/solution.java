public class Solution {
    //faster than n! but still time out
    // Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
    
    // public int maxCoins(int[] nums) {
    //     List<Integer> list = new ArrayList<Integer>();
    //     if(nums.length == 0)return 0;
    //     for(int i : nums) {
    //         list.add(i);
    //     }
    //     return help(list);
    // }
    
    // private int help(List<Integer> list) {
    //     if(list.size() == 1)return list.get(0);
    //     if(map.containsKey(list))return map.get(list);
    //     int max = Integer.MIN_VALUE;
    //     int res = 0;
    //     for(int i = 0; i < list.size(); i++) {
    //         if(i == 0) {
    //             res = list.get(0) * list.get(1);
    //             int old = list.get(0);
    //             list.remove(0);
    //             res += help(list);
    //             list.add(0, old);
    //         }
    //         else if(i == list.size() - 1) {
    //             res = list.get(i) * list.get(i - 1);
    //             int old = list.get(i);
    //             list.remove(i);
    //             res += help(list);
    //             list.add(i, old);
    //         }
    //         else {
    //             res = list.get(i - 1) * list.get(i) * list.get(i + 1);
    //             int old = list.get(i);
    //             list.remove(i);
    //             res += help(list);
    //             list.add(i, old);
    //         }
    //         if(max < res)max = res;
    //     }
    //     map.put(list, max);
    //     return max;
    // }
    public int maxCoins(int[] nums) {
        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];
        int n = nums.length;
        int[] coins = new int[n + 2];
        for(int i = 1; i <= n; i++) {
            coins[i] = nums[i - 1];
        }
        coins[0] = 1;
        coins[n + 1] = 1;
        int[][] memo = new int[n + 2][n + 2];
        return help(coins, 0, n + 1, memo);
    }
   
    
    private int help(int coins[], int left, int right, int[][] memo) { 
        
        if(left == right - 1)return 0;
        
        if(memo[left][right] != 0) return memo[left][right];
        int m = Integer.MIN_VALUE;
        for(int i = left + 1; i < right; i++) {
    
            m = Math.max(m, help(coins, left, i, memo) + help(coins, i, right, memo) +  coins[i] * coins[left] * coins[right]);
            
        }
        memo[left][right] = m;
        return m;
    }
}