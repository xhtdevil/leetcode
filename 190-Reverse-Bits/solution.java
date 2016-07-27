public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if(n < 0){long m = 0x100000000L + n;}
        else{long m = (long) n;}
        int reverse = 0;
        for(int i = 0; i < 32; i++){
            reverse = (int) (2 * reverse + m % 2);
            m = m / 2;
        }
        return reverse;
    }
}