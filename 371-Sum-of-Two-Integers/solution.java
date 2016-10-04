public class Solution {
    public int getSum(int a, int b) {
        // only positive sum
        // int ans = 0;
        // int c = 0;
        // int div = 1;
        // while(a > 0 || b > 0) {
            
        //     int a0 = a & 1;
        //     int b0 = b & 1;
        //     if((a0 & b0 & c) == 1) {            //must add () among &
        //         c = 1;
        //         ans = ans | div; 
        //     }
        //     else if((a0 | b0 | c) == 0) {
        //         c = 0;
                
        //     }
        //     else if((a0 & b0) == 1 || (a0 & c) == 1 || (b0 & c) == 1) {
        //         c = 1;
        //     }
        //     else {
        //         c = 0;
        //         ans = ans | div;
        //     }
        //     a >>= 1;
        //     b >>= 1;
        //     div <<= 1;
        // }
        // if(c == 1)ans |= div;
        // return ans;
        if(a == 0)return b;
        if(b == 0)return a;
        while(b != 0) {
            int c = a & b;
            a = b ^ a;
            b = c << 1;
            
        }
        return a;
    }
}