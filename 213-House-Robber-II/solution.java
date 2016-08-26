public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)return 0;
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
        // if(nums.length == 1)return nums[0];
        // int n = nums.length;
        // int[] rob0 = new int[n];
        // int[] rob1 = new int[n];
        // rob0[0] = 0;
        // rob1[0] = nums[0];
        // rob0[1] = nums[1];
        // rob1[1] = nums[0];
        // for(int i = 2; i < n; i++){
        //     rob0[i] = Math.max(rob0[i - 2] + nums[i], rob0[i - 1]);
        //     rob1[i] = Math.max(rob1[i - 1], rob0[])
        }
    
    private int helper(int[] nums, int start, int end){
        int max[] = new int[end + 1];
        max[start] = nums[start];
        max[start + 1] = Math.max(nums[start], nums[start + 1]); 
        for(int i = start + 2; i <= end; i++){
            max[i] = Math.max(max[i - 2] + nums[i], max[i - 1]);
        }
        return max[end];
    }
}