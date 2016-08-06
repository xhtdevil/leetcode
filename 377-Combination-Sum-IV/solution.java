public class Solution {
    private int[] r;
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        r = new int[target + 1];
        for(int i = 0; i < target + 1; i++){
            r[i] = -1;
        }
        r[0] = 1;
        return combination(nums, target);
    }
    public int combination(int[] nums, int target) {
        if(r[target] != -1)return r[target];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(target - nums[i] >= 0){
                sum += combination(nums, target - nums[i]);
            }
        }
        r[target] = sum;
        return sum;
    }
}