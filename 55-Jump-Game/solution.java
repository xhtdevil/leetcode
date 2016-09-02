public class Solution {
    public boolean canJump(int[] nums) {
        return helper(nums, 0);
    }
    
    private boolean helper(int[] nums, int start){
        if(start == nums.length - 1)return true;
        boolean res = false;
        for(int i = Math.min(nums[start], nums.length - start - 1); i >= 1; i--){
            res = res || helper(nums, start + i);
            if(res == true)return res;
        }
        return res;
    }
}