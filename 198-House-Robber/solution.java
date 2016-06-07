public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0){return 0;}
        else if(nums.length == 1){return nums[0];}
        else if(nums.length == 2){return Math.max(nums[0],nums[1]);}
        else {
            int largest_now = 0, largest_s1 = Math.max(nums[0],nums[1]), largest_s2 = nums[0];
            for(int i = 2; i < nums.length; i++){
                largest_now = Math.max(largest_s1, largest_s2 + nums[i]);
                largest_s2 = largest_s1;
                largest_s1 = largest_now;
            }
            return largest_now;
            // int[] nums1 = new int[nums.length - 1];
            // int[] nums2 = new int[nums.length - 2];
            // int i = 0;
            // while(i < nums.length - 1){
            //     nums1[i] = nums[i];
            //     if(i != nums.length - 2){
            //         nums2[i] = nums[i];
            //     }
            // }
            // return Math.max(rob(nums1),rob(nums2) + nums[nums.length - 1]);
        }
    }
}