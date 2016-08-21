public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        int[] index = new int[m];
    //    index[0] = 0;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++){
            res[i] = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++){
                res[i] = Math.min(res[i], primes[j] * res[index[j]]);
            }
            for(int j = 0; j < m; j++){
                if(primes[j] * res[index[j]] <= res[i]){index[j]++;}
            }
        }
        return res[n - 1];
    }
}