public class Solution {
    private int min;
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int r[] = new int[target + 1];
        int min = - Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(nums[i] < min){min  = nums[i];}
        }
        for(int i = 0; i < target + 1; i++){
            r[i] = -1;
        }
        return combination(nums, target, r);
    }
    public int combination(int[] nums, int target, int[] r) {
        int sum = 0;
        if(target == 0)return 1;
        if(target < min)return 0;
        if(r[target] > 0)return r[target];
        for(int i = 0; i < nums.length; i++){
            sum += combination(nums, target - nums[i], r);
        }
        r[target] = sum;
        return sum;
    }
}