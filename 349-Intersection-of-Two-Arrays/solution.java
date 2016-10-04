public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        Set<Integer> set = new HashSet<Integer>();
        int r = 0;
        for(int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if(nums1[i] > nums2[j]) j++;
            else if(nums1[i] < nums2[j]) i++;
            else {
                if(set.add(nums1[i])) ans[r++] = nums1[i];
                i++;
                j++;
            }
        }
        int[] ans2 = new int[r];
        for(int i = 0; i < r; i++) {
            ans2[i] = ans[i];
        }
        return ans2;
    }
}