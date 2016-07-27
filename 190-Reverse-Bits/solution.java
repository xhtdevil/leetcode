public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long m = 0;
        if(n < 0){m = 0x100000000L + n;}
        else{m = (long) n;}
        int reverse = 0;
        for(int i = 0; i < 32; i++){
            reverse = (int) (2 * reverse + m % 2);
            m = m / 2;
        }
        return reverse;
    }
}