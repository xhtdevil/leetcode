public class Solution {
    public int maxProduct(int[] nums) {
        int mul = nums[0], max = mul, min = mul;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            mul = Math.max(max, mul);
        }
        return mul;
    }
}