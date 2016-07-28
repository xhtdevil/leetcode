public class Solution {
    // overflow if rx > 2^31
    public int reverse(int x) {
        if(x == -2147483648)return 0;
        int absx = Math.abs(x);
        int rx = 0;
        while(absx != 0){
            if(rx > 0x7fffffff / 10){return 0;}
            rx = 10 * rx + absx % 10;
            absx = absx / 10;
        }
        if(x < 0)return -rx;
        else return rx;
    }
}