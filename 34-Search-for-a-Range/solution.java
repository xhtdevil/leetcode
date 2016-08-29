public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)return new int[]{-1, -1};
        int start = findGE(nums, target, 0, nums.length - 1);
        if(start >= nums.length || nums[start] != target){
            return new int[]{-1, -1};
        }
        int end = findGE(nums, target + 1, 0, nums.length) - 1;
        return new int[]{start, end};
    }
    
    private int findGE(int[] nums, int target, int left, int right){
        
        if(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){return findGE(nums, target, mid + 1, right);}
            else {return findGE(nums, target, left, mid);}
        }
        
        else {
            return right;
        }
    }
}