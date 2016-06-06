public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while(n != 0){
            res = n % 2;
            n = n / 2;
            ans += res;
        }
        return ans;
    }
}