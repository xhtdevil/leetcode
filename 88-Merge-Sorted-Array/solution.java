public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0)return;
        if(m == 0){
            for(int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        for(int i = 0; i < m; i++){
            nums1[i + n] = nums1[i];
        }
        int j = 0, k = 0, g = 0;
        while(j != m || k != n){
            if(k == n || nums1[n + j] < nums2[k]){
                nums1[g] = nums1[m + j];
                g++;
                j++;
            }
            else{
                nums1[g] = nums2[k];
                g++;
                k++;
            }
        }
    }
}