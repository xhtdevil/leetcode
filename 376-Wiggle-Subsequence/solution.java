public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2)return nums.length;
        int size = 1;
        int trend = 0;
        // while(nums[i] == nums[i + 1]){
        //     i++;
        // }
        // if(nums[i] > nums[i + 1])trend = 1;
        // else trend = -1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1] && trend <= 0){
                size++;
                trend = 1;
            }
            else if(nums[i] < nums[i - 1] && trend >= 0){
                size++;
                trend = -1;
            }
        }
        return size;
    }
}