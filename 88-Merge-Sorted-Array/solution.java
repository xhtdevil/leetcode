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
            nums1[m + n - 1 - i] = nums1[m - i - 1]; //copy nums1 to the end of the array
        }
        int j = 0, k = 0, g = 0;
        while(j != m || k != n){
            if(j == m){
                nums1[g] = nums2[k];
                g++;
                k++;
            }
            else if(k == n || nums1[n + j] < nums2[k]){
                nums1[g] = nums1[n + j];
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