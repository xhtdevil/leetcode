public class Solution {
    public double myPow(double x, int n) {
        //double mul = 1;
        if(n == 0)return 1;
        else if(n > 0){
            if(n % 2 == 0)return myPow(x * x, n / 2);
            else    return x * myPow(x * x, (n - 1) / 2); 
        }
        else{
            if(Math.abs(n) % 2 == 0)return myPow(x * x, n / 2);
            else    return myPow(x * x, (n + 1) / 2) / x; 
        }
    }
}