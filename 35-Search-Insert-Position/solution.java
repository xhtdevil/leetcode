public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0)return 0;
        return helper(nums, target, 0, nums.length - 1);
    }
    private int helper(int[] nums, int target, int left, int right){
        int mid = left + (right - left) / 2;
        if(left < right){
            if(target > nums[mid]){
                return helper(nums, target, mid + 1, right);
            }
            else if(target < nums[mid]){
                return helper(nums, target, left, mid - 1);
            }
            else{
                return mid;
            }
        }
        else{
            if(target <= nums[right])return right;
            if(target > nums[right])return right + 1;
        }
        return 0;
    }
}