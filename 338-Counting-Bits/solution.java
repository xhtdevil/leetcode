public class Solution {
    public int[] countBits(int n) {
        //solution1
        // int nums[] = new int[num + 1];
        // for(int i = 1; i <= num; i++){
        //     nums[i] = nums[i / 2] + i % 2;
        // }
        // return nums;
       
        int[] a = new int[n + 1];
        a[0] = 0;
        int div = 1;
        for(int i = 1; i <= n; i++) {
            if(i >= div * 2) {
                div *= 2;
            }
            a[i] = a[i % div] + 1;        
        }
        return a;
    }
}