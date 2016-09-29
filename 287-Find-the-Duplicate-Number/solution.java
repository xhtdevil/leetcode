public class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        return help(nums, 0, nums.length - 1);
        
    }
    
    private int help(int[] nums, int left, int right) {
        if(left == right)return nums[left]; 
        int count = 0;
        int mid = left + (right - left) / 2;
        for(int i = left; i <= right; i++) {
            if(nums[i] <= mid) count++;
        }
        if(count <= (right - left) / 2)return help(nums, mid + 1, right);
            else return help(nums, left, mid);
    }
}