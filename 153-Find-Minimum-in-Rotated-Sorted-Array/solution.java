public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 0)return 0;
        if(n == 1)return nums[0];
        int start = 0, end = n - 1;
        int mid;
        while(start < end){
            mid = start + (end - start) / 2;
            if(mid > 0 && nums[mid] < nums[mid - 1])return nums[mid];
            else if(nums[mid] >= nums[start] && nums[mid] > nums[end]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return nums[start];
    }
}