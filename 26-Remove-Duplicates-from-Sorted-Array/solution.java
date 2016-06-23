public class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        for(int i = 1; i < length;){
            if(nums[i] == nums[i - 1]){
                nums[i - 1] = nums[length - 1];
                length--;
            }else{
                i++;
            }
        }
        return length;
    }
}