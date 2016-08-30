public class Solution {
    
    private int min = Integer.MAX_VALUE;
    
    private int ans = 0;
    
    public int threeSumClosest(int[] nums, int target) {
        int times = 3;
        helper(nums, target, 0, 0, times);
        return ans;
    }
    
    private void helper(int[] nums, int target, int start, int sum, int times){
        if(times == 0){
            if(Math.abs(target) < min){
                ans = sum;
                min = Math.abs(target);
            }
        }
        for(int i = start; i < nums.length; i++){
            sum += nums[i];
            helper(nums, target - nums[i], i + 1, sum, times - 1);
            sum -= nums[i];
        }
    } 
}