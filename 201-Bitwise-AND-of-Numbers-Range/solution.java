public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        
       // int p = m & n;
        int digit = 0;
        while(m != 0 || n != 0){
            if((m == 0 && n != 0) || (m != 0 && n == 0))return 0;
            if(m == n)break;
            m = m >> 1;
            n = n >> 1;
            digit++;
        }
        while(digit != 0){
            m = m << 1;
            digit--; 
        }
        return m;
        // int q = p;
        // int digit = 0;
        // int highZero = 0;
        // while(q != 0){
        //     digit++;
        //     if(q % 2 == 0)highZero = digit;
        //     q = q >> 1;
        // }
        // int filter = 1 << highZero;
        // return p - p % filter;
    }
}