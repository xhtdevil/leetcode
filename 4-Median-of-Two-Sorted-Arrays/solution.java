public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // O((m + n) / 2)
        // int i = 0, j = 0;
        // if(nums1.length == 0 && nums2.length == 0) return 0;
        if(nums1.length == 0) {
            if(nums2.length % 2 == 1)return nums2[nums2.length / 2];
            else return (double)(nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
        }
         if(nums2.length == 0) {
            if(nums1.length % 2 == 1)return nums1[nums1.length / 2];
            else return (double)(nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0;
        }
        // int median[] = new int[2];
        // int smedian = 0;
        // int r = 0;
        // while(i + j <= (nums1.length + nums2.length) / 2) {
        //     if(j >= nums2.length || i < nums1.length && nums1[i] < nums2[j]){
        //         median[r++] = nums1[i];
        //         smedian = nums1[i];
        //         i++;
        //         r = r % 2;
        //     }
                
        //     else {
                
        //         median[r++] = nums2[j];
        //         smedian = nums2[j];
        //         j++;
        //         r = r % 2;
        //     }
                
        // }
        // if((nums1.length + nums2.length) % 2 == 1) {
        //     return (double) smedian;
        // }
        // else {
        //     return (double) (median[0] + median[1]) / 2.0;
        // }
        int m = nums1.length, n = nums2.length;
        if(m > n){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int i = help(0, nums1.length, nums1, nums2);
        int j = (nums1.length + nums2.length + 1) / 2 - i;
        if ((nums1.length + nums2.length) % 2 == 1) {
            //return i;
            if(i == 0)return nums2[j - 1];
            if(j == 0)return nums1[i - 1];
            else return Math.max(nums1[i - 1], nums2[j - 1]);
        }
        else {
            int max, min;
            if(i == 0)max = nums2[j - 1];
            else if(j == 0)max = nums1[i - 1];
            else max = Math.max(nums1[i - 1], nums2[j - 1]);
            if(i == nums1.length)min = nums2[j];
            else if(j == nums2.length)min = nums1[i];
            else min = Math.min(nums1[i], nums2[j]);
            return (double)(max + min) / 2.0;
        }
    }
    private int help(int start, int end, int[] nums1, int[] nums2) {
        int i = start + (end - start) / 2;
        int j = (nums1.length + nums2.length + 1) / 2 - i;
        if((i == 0 || j == nums2.length || nums1[i - 1] <= nums2[j]) && (i == nums1.length || j == 0 || nums1[i] >= nums2[j - 1])) {
            return i;
        }
        else if(nums1[i] < nums2[j - 1]) {
            return help(i + 1, end, nums1, nums2);
        }
        else return help(start, i - 1, nums1, nums2);
    }
}