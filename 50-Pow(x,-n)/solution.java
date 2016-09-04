public class Solution {
    public double myPow(double x, int n) {
        double mul = 1;
        if(n >= 0){
            for(int i = 0; i < n; i++){
                mul *= x;
            }
        }
        else{
            for(int i = 0; i < Math.abs(n); i++){
                mul /= x;
            }
        }
        return mul;
    }
}