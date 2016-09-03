public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)return 0;
        int left = 0, right = nums.length - 1, sum = 0, size = nums.length;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum < s)return 0;
        while(left <= right){
            if(nums[left] <= nums[right]){
                sum -= nums[left];
                size--;
                left++;
            }
            else{
                sum -= nums[right];
                size--;
                right++;
            }
            if(sum < s)return size + 1;
        }
        return 0;
    }
}