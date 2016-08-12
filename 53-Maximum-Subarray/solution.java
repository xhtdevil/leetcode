public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int  i = 0;
        int max = Integer.MIN_VALUE;
        for(int j = 0; j < nums.length; j++){
            sum += nums[j];
            if(sum > max){max = sum;}
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}