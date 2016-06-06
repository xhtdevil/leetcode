public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> nums3 = new ArrayList<Integer>();
        int i = 0, j = 0;
        while(i != nums1.length && j != nums2.length){
            if(nums1[i] == nums2[j]){
                nums3.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] > nums2[j]){
                j++;
            }
            else if(nums1[i] < nums2[j]){
                i++;
            }
        }
        int[] nums4 = new int[nums3.size()];
        for(int m = 0; m < nums3.size(); m++){
            nums4[m] = nums3.get(m);
        }
        return nums4;
    }
}