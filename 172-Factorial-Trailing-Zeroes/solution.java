public class Solution {
    public int trailingZeroes(int n) {
        int deg = 5;
        int tZ = n / deg;
        int result = tZ;
        while(tZ > 1){
            deg *= 5;
            tZ = n / deg;
            result += tZ;
        }
        return result;
    }
}