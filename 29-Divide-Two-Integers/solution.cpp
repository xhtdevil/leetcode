class Solution {
public:
    int divide(int dividend, int divisor) {
        if(divisor == 0)return INT_MAX;
        if(dividend == 0)return 0;
        if(dividend == INT_MIN && divisor == -1)return INT_MAX;
        int d1 = dividend, d2;
        int n = d2;
        int res = 0;
        if(dividend < 0) {
            d2 = - abs(divisor);
            n = d2;
            while(n >= d1){
                int rec = 1;
                while(n << 1 >= d1 && n << 1 < 0) {
                    n = n << 1;
                    rec = rec << 1;
                }
                res += rec;
                d1 = d1 - n;
                n = d2;
            }
        }
        
        else {
            d2 = abs(divisor);
            n = d2;
            while(n <= d1){
                int rec = 1;
                while(n << 1 < d1 && n << 1 > 0) {
                    n = n << 1;
                    rec = rec << 1;
                }
                res += rec;
                d1 = d1 - n;
                n = d2;
            }
        }
        
        if((dividend > 0) ^ (divisor > 0)){
        return -res;
        }
        else return res;
    }
};