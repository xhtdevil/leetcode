public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        int start = 0, end  = n + 1;
        long[] sum = new long[n + 1];
        for(int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i]; 
        }
        return help(sum, start, end, lower, upper);
        
    }
    
    //merge sort, sort both halves after count the rangesum
    public int help(long[] sum, int start, int end, int lower, int upper) {
        if(end - start <= 1)return 0;
        int mid = start + (end - start) / 2;
        int count = help(sum, start, mid, lower, upper) + help(sum, mid, end, lower, upper);
        int t = mid, j = mid, k = mid;
        long[] cache = new long[end - start];
        for(int i = start, r = 0; i < mid; i++,r++) {
            while(j < end && sum[j] - sum[i] < lower) j++;
            while(k < end && sum[k] - sum[i] <= upper) k++;
            while(t < end && sum[t] < sum[i]) cache[r++] = sum[t++];            //merge sort after counting
            cache[r] = sum[i];
            count += k - j;
        }
        System.arraycopy(cache, 0, sum, start, t - start);
        return count;
    }
}