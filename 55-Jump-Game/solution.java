public class Solution {
    public boolean canJump(int[] nums) {
        return helper(nums, 0);
    }
    
    private boolean helper(int[] nums, int start){
        if(start == nums.length - 1)return true;
        boolean res = false;
        for(int i = 1; i <= nums[start] && i + start <= nums.length - 1; i++){
            res = res || helper(nums, start + i);
            if(res == true)return res;
        }
        return res;
    }
}