public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length == 0)return;
       // if(nums1)
        for(int i = 0; i < m; i++){
            nums1[i + n] = nums1[i];
        }
        int j = 0, k = 0, g = 0;
        while(j != m || k != n){
            if(nums1[n + j] < nums2[k] || k == n){
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
        // if(j == m){
        //     while(k <= n){
        //         nums1[g] = nums2[k]
        //         k++;
        //     }
        // }
        // if(k == n){
        //     while(j <= m){
        //         nums1[g] = nums1[m + j];
                
        //     }
        // }
    }
}