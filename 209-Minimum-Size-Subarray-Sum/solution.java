public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)return 0;
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0, sum = 0;
        while(j < nums.length){
            sum += nums[j];
            j++;
            while(sum >= s){
                min = Math.min(min, j - i);
                sum -= nums[i];
                i++;
            }
        }
        if((j - i) == nums.length && sum < s)return 0;
        return min;
    }
}