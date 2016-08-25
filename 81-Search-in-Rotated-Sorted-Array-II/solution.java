public class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end){
            
            int mid = start + (end - start) / 2;
            if(target == nums[mid])return true;
            else if(nums[mid] == nums[start] && nums[mid] == nums[end]){
                start = start + 1;
                end = end - 1;
            }
            else if(nums[start] <= nums[mid] && nums[end] <= nums[mid]){
                if(target < nums[mid] && target >= nums[start]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
    
    // private boolean helper(int[] nums, int start, int end, int target, int maxIn){
    //     int mid = (start + maxIn + 1) % nums.length + (end - start) / 2;
    //     if()
    // }
}