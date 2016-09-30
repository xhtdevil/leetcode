public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0)return -1;
        return help(nums, 0, nums.length - 1);
    }
    
    private int help(int[] nums, int left, int right) {
        if(left > right) return -1;
        if(right == left) return nums[left];
        if(right - 1 == left) {
            if(nums[left] < nums[right]) return nums[left];
            else return nums[right];
        }
        int mid = left + ( right - left ) / 2;
        if(nums[mid] < nums[right] && nums[mid] > nums[left] || nums[mid] <= nums[right] && nums[mid] > nums[left] || nums[mid] < nums[right] && nums[mid] >= nums[left]) {
            return nums[left];
        }
        else if(nums[mid] <= nums[right] && nums[mid] < nums[left]) {
            return help(nums, left + 1, mid);
        }
        else if(nums[mid] > nums[right] && nums[mid] >= nums[left]) {
            return help(nums, mid + 1, right);
        }
        else if(nums[mid] ==  nums[right] && nums[mid] == nums[left]) {
            return help(nums, left + 1, right - 1);
        }
        else return -1;
    }
}