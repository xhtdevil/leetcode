public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length <= 1 || k <= 0)return false;
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++) { 
           // int floor = treeSet.floor(nums[i] + t);
           // int ceil = treeSet.ceiling(nums[i] - t);
            if( treeSet.floor(nums[i] + t) != null && treeSet.floor(nums[i] + t) >= nums[i] || treeSet.ceiling(nums[i] - t) != null && treeSet.ceiling(nums[i] - t) <= nums[i]) return true;
            treeSet.add(nums[i]);
            if( i >= k) treeSet.remove(nums[i - k]);
        }
        return false;
    }
}