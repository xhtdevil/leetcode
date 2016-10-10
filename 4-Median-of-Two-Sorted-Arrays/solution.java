public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        if(nums1.length == 0 && nums2.length == 0) return 0;
        if(nums1.length == 0) {
            if(nums2.length % 2 == 1)return nums2[nums2.length / 2];
            else return (double)(nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
        }
         if(nums2.length == 0) {
            if(nums1.length % 2 == 1)return nums1[nums1.length / 2];
            else return (double)(nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0;
        }
        int median[] = new int[2];
        int smedian = 0;
        int r = 0;
        while(i + j <= (nums1.length + nums2.length) / 2) {
            if(j >= nums2.length || i < nums1.length && nums1[i] < nums2[j]){
                median[r++] = nums1[i];
                smedian = nums1[i];
                i++;
                r = r % 2;
            }
                
            else {
                
                median[r++] = nums2[j];
                smedian = nums2[j];
                j++;
                r = r % 2;
            }
                
        }
        if((nums1.length + nums2.length) % 2 == 1) {
            return (double) smedian;
            // if(i == 0 && j != 0|| (i != 0  && j != 0 && nums1[i - 1] <= nums2[j - 1])) {return (double)nums2[j - 1];}
            // else return (double)nums1[i - 1];
        }
        //if((nums1.length + nums2.length) % 2 == 1)return nums1[i - 1] > nums2[j - 1]? nums1[i - 1]:nums2[j - 1];
        else {
            return (double) (median[0] + median[1]) / 2.0;
            // int a1, a2;
            // if(i == 0 && j != 0 || (i != 0  && j != 0 && nums1[i - 1] <= nums2[j - 1])) {
            //     a1 = nums2[j - 1];
            //     a2 = nums1[i];
            //     return (double)(a1 + a2) / 2.0;
            // }
            // else {
            //     return (double) (nums2[j] + nums1[i - 1]) / 2.0;
            // }
        }
    }
}